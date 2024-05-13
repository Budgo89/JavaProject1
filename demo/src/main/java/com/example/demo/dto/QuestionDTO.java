package com.example.demo.dto;


import java.util.List;

public class QuestionDTO {
    private String question;
    private List<String> answers;

    public QuestionDTO(String question, List<String> answers) {
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
