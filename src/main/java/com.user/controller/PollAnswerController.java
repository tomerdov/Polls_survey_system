package com.user.controller;

import com.user.model.PollAnswer;
import com.user.model.PollResult;
import com.user.service.PollsAnswer.PollAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/poll-answer")
public class PollAnswerController {

    @Autowired
    private PollAnswerService pollAnswerService;

    @PostMapping("/vote")
    public String vote(@RequestBody PollAnswer pollAnswer) throws Exception {
        pollAnswerService.vote(pollAnswer);
        return "Vote submitted successfully";
    }

    @GetMapping("/results/{pollId}")
    public PollResult getPollResults(@PathVariable Long pollId) throws Exception {
        return pollAnswerService.getPollResults(pollId);
    }
}
