package com.user.service.PollsAnswer;

import com.user.model.PollAnswer;
import com.user.model.PollResult;

public interface PollAnswerService {

    void vote(PollAnswer pollAnswer) throws Exception;
    PollResult getPollResults(Long pollId);
}