package com.user.repository.mapper;

import com.user.model.PollResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PollResultMapper implements RowMapper<PollResult> {

    @Override
    public PollResult mapRow(ResultSet rs, int rowNum) throws SQLException {

        PollResult result = new PollResult();

        result.setFirstAnswerCount(rs.getInt("first_count"));
        result.setSecondAnswerCount(rs.getInt("second_count"));
        result.setThirdAnswerCount(rs.getInt("third_count"));
        result.setFourthAnswerCount(rs.getInt("fourth_count"));

        return result;
    }
}