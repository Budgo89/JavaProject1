package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class AnswerDTO {
    private String userName;
    private List<Answer> answers = new ArrayList<Answer>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "AnswerDTO{" +
                "userName='" + userName + '\'' +
                ", answers=" + answers +
                '}';
    }
}
