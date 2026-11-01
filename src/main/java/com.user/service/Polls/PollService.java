package com.user.service.Polls;

import com.user.model.Poll;

public interface PollService {
    Long createQuestion(Poll poll) throws Exception;

    void updateQuestion(Poll poll) throws Exception;

    void deleteQuestionById(Long id) throws Exception;

    Poll getQuestionById(Long id) throws Exception;
}
