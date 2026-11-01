package com.user.repository.Polls;

import com.user.model.Poll;

public interface PollRepository {
    Long createQuestion(Poll question) throws Exception;

    void updateQuestion(Poll question) throws Exception;

    void deleteQuestionById(Long id) throws Exception;


    Poll getQuestionById(Long id) throws Exception;
}
