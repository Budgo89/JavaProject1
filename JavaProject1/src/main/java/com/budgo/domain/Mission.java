package com.budgo.domain;

import java.util.HashMap;

public class Mission {

    private final int id;
    private final String question;
    private final int rightAnswer;
    private HashMap<Integer, String> answers;

    public Mission(int id, String question, int rightAnswer, String answer1, String answer2, String answer3) {
        this.id = id;
        this.question = question;
        this.rightAnswer = rightAnswer;
        addAnswer(answer1, answer2, answer3);
    }

    private void addAnswer(String answer1, String answer2, String answer3) {
        answers = new HashMap<Integer, String>();
        answers.put(1, answer1);
        answers.put(2, answer2);
        answers.put(3, answer3);
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public HashMap<Integer, String> getAnswers() {
        return answers;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }
}
