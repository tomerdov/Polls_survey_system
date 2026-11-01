package com.user.repository.PollsAnswer;

import com.user.model.PollAnswer;
import com.user.model.PollResult;

public interface PollAnswerRepository {

    void vote(PollAnswer pollAnswer) throws Exception;
    PollResult getPollResults(Long pollId);
}