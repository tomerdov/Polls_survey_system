package com.user.service.Polls;

import com.user.model.Poll;

import com.user.repository.Polls.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class PollServiceimp implements PollService {
    @Autowired
    PollRepository pollRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Long createQuestion(Poll poll) throws Exception {
        //Object Mapper reference
        String pollAsString = objectMapper.writeValueAsString(poll);
        System.out.println("Starting create a poll : " + pollAsString);
        Poll pollFromString = objectMapper.readValue(pollAsString, Poll.class);


        return pollRepository.createQuestion(poll);
    }

    @Override
    public void updateQuestion(Poll poll) throws Exception {
        pollRepository.updateQuestion(poll);
    }

    @Override
    public void deleteQuestionById(Long id) throws Exception {
      pollRepository.deleteQuestionById(id);
    }

    @Override
    public Poll getQuestionById(Long id) throws Exception {
        return pollRepository.getQuestionById(id);
    }

}
