package com.user.repository.Polls;

import com.user.model.Poll;
import com.user.repository.mapper.PollMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;



@Repository
public class PollQuestionRepositoryImp implements PollRepository {
    private static String POLL_TABLE_NAME = "com.user/Poll";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Long createQuestion(Poll poll) throws Exception {

        String sql = "INSERT INTO polls " +
                "(title, answer1 , answer2 , answer3, answer4)" +
                "VALUES (?, ?, ?, ?, ?)";
        try {
            System.out.println("Title: " + poll.getTitle());
            System.out.println("Answer 1: " + poll.getFirstAnswer());
            System.out.println("Answer 2: " + poll.getSecondAnswer());
            System.out.println("Answer 3: " + poll.getThirdAnswer());
            System.out.println("Answer 4: " + poll.getFourthAnswer());
            jdbcTemplate.update(
                    sql,
                    poll.getTitle(),
                    poll.getFirstAnswer(),
                    poll.getSecondAnswer(),
                    poll.getThirdAnswer(),
                    poll.getFourthAnswer()
            );
            return poll.getId();
        } catch (Exception e) {
            throw new Exception("Something went wrong", e);
        }
    }


    @Override
    public void updateQuestion(Poll poll) throws Exception {

        String sql = "UPDATE polls SET " +
                "title = ?, " +
                "answer1 = ?, " +
                "answer2 = ?, " +
                "answer3 = ?, " +
                "answer4 = ? " +
                "WHERE id = ?";

        jdbcTemplate.update(
                sql,
                poll.getTitle(),
                poll.getFirstAnswer(),
                poll.getSecondAnswer(),
                poll.getThirdAnswer(),
                poll.getFourthAnswer(),
                poll.getId()
        );
    }


    @Override
    public void deleteQuestionById(Long id) throws Exception {

        String sql = "DELETE FROM polls WHERE id = ?";

        jdbcTemplate.update(sql, id);
    }


    @Override
    public Poll getQuestionById(Long id) throws Exception {

        String sql = "SELECT * FROM polls WHERE id = ?";

        try {
            return jdbcTemplate.queryForObject(
                    sql,
                    new PollMapper(),
                    id
            );
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Not found");
            return null;
        }
    }
}