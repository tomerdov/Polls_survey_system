package com.user.controller;

import com.user.model.Poll;
import com.user.service.Polls.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/poll")
public class PollController {

    @Autowired
    private PollService pollService;

    @PostMapping("/create")
    public Long createQuestion(@RequestBody Poll poll) throws Exception {
        return pollService.createQuestion(poll);
    }

    @PutMapping("/update")
    public void updateQuestion(@RequestBody Poll poll) throws Exception {
        pollService.updateQuestion(poll);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteQuestionById(@PathVariable long id) throws Exception {
       pollService.deleteQuestionById(id);
    }

    @GetMapping("/{id}")
    public Poll getQuestionById(@PathVariable long id) throws Exception {
        return pollService.getQuestionById(id);
    }
}
