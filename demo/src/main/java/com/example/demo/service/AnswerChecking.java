package com.example.demo.service;

import com.example.demo.domain.Mission;
import com.example.demo.domain.Missions;
import com.example.demo.domain.Student;
import com.example.demo.dto.Answer;
import com.example.demo.dto.AnswerDTO;

import org.springframework.stereotype.Service;


@Service
public class AnswerChecking {

    private final Missions missions;

    public AnswerChecking(MissionService missionService) {

        this.missions = missionService.getMissions();
    }

    public Student checkingAnswer(AnswerDTO answers) {

        Student student = new Student();

        student.setName(answers.getUserName());
        student.setSurname(answers.getSurname());

        for (Answer answer : answers.getAnswers()) {
            if (isAnswer(answer.getQuestionId(), answer.getAnswerId())) {
                student.setCorrectAnswer();
            }
        }
        return student;
    }

    public boolean isAnswer(int questionId, int answerId) {
        Mission mission = missions.missionList.get(questionId - 1);

        return answerId == mission.getRightAnswer();
    }
}
