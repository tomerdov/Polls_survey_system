package com.user.model;

public class PollAnswer {
    private Long PollAnswerId;
    private Long userId;
    private Long pollId;
    private int selectedOption;

    public PollAnswer() {
    }

    public Long getPollAnswerId() {
        return PollAnswerId;
    }

    public void setPollAnswerId(Long id) {
        this.PollAnswerId = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    public int getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(int selectedOption) {
        this.selectedOption = selectedOption;
    }
}
