package com.user.service.PollsAnswer;

import com.user.model.PollResult;
import com.user.model.User;
import com.user.model.PollAnswer;
import com.user.repository.PollsAnswer.PollAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.repository.user.UserRepository;

@Service
public class PollAnswerServiceImp implements PollAnswerService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PollAnswerRepository pollAnswerRepository;

    @Override
    public void vote(PollAnswer pollAnswer) throws Exception {
        User user = userRepository.getUserById(pollAnswer.getUserId());

        if (user == null) {
            throw new Exception("User not found");
        }

        if (!user.isRegistered()) {
            throw new Exception("User is not registered");
        }
        pollAnswerRepository.vote(pollAnswer);
    }
    @Override
    public PollResult getPollResults(Long pollId) {
        return pollAnswerRepository.getPollResults(pollId);
    }
}