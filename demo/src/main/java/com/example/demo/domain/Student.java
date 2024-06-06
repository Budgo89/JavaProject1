package com.example.demo.domain;

import lombok.Data;

@Data
public class Student {
    private String name;
    private String Surname;
    private int correctAnswer;

    public void setCorrectAnswer() {
        correctAnswer++;
    }
}
