package com.budgo.domain;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private String name;
    private String Surname;
    private int correctAnswer;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer() {
        correctAnswer++;
    }
}
