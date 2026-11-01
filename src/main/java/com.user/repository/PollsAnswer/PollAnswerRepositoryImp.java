package com.user.repository.PollsAnswer;

import com.user.model.PollAnswer;
import com.user.model.PollResult;
import com.user.repository.mapper.PollResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class PollAnswerRepositoryImp implements PollAnswerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Override
    public void vote(PollAnswer pollAnswer) throws Exception {

        String sql = "INSERT INTO poll_answers " +
                "(user_id, poll_id, selected_option) " +
                "VALUES (?, ?, ?)";

        try {
            jdbcTemplate.update(
                    sql,
                    pollAnswer.getUserId(),
                    pollAnswer.getPollId(),
                    pollAnswer.getSelectedOption()
            );

        } catch (Exception e) {
            throw new Exception("Something went wrong", e);
        }
    }
    @Override
    public PollResult getPollResults(Long pollId) {

        String sql = "SELECT " +
                "COUNT(CASE WHEN selected_option = 1 THEN 1 END) AS first_count, " +
                "COUNT(CASE WHEN selected_option = 2 THEN 1 END) AS second_count, " +
                "COUNT(CASE WHEN selected_option = 3 THEN 1 END) AS third_count, " +
                "COUNT(CASE WHEN selected_option = 4 THEN 1 END) AS fourth_count " +
                "FROM poll_answers WHERE poll_id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new PollResultMapper(),
                pollId
        );
    }
}
