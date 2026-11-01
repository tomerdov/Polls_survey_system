package com.user.model;

public class PollResult {

    private Long pollId;
    private int firstAnswerCount;
    private int secondAnswerCount;
    private int thirdAnswerCount;
    private int fourthAnswerCount;

    public PollResult() {
    }

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    public int getFirstAnswerCount() {
        return firstAnswerCount;
    }

    public void setFirstAnswerCount(int firstAnswerCount) {
        this.firstAnswerCount = firstAnswerCount;
    }

    public int getSecondAnswerCount() {
        return secondAnswerCount;
    }

    public void setSecondAnswerCount(int secondAnswerCount) {
        this.secondAnswerCount = secondAnswerCount;
    }

    public int getThirdAnswerCount() {
        return thirdAnswerCount;
    }

    public void setThirdAnswerCount(int thirdAnswerCount) {
        this.thirdAnswerCount = thirdAnswerCount;
    }

    public int getFourthAnswerCount() {
        return fourthAnswerCount;
    }

    public void setFourthAnswerCount(int fourthAnswerCount) {
        this.fourthAnswerCount = fourthAnswerCount;
    }
}

