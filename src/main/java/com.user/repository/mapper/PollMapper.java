package com.user.repository.mapper;

import com.user.model.Poll;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PollMapper implements RowMapper<Poll> {
    @Override
    public Poll mapRow(ResultSet rs, int rowNum) throws SQLException {

        Poll poll = new Poll();

        poll.setId(rs.getLong("id"));
        poll.setTitle(rs.getString("title"));
        poll.setFirstAnswer(rs.getString("first_answer"));
        poll.setSecondAnswer(rs.getString("second_answer"));
        poll.setThirdAnswer(rs.getString("third_answer"));
        poll.setFourthAnswer(rs.getString("fourth_answer"));

        return poll;
    }
}
