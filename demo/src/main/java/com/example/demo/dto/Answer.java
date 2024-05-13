package com.example.demo.dto;

public class Answer{
    private int questionId;
    private int answerId;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "questionId=" + questionId +
                ", answerId=" + answerId +
                '}';
    }
}
