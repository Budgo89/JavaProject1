package com.budgo.service;

import com.budgo.domain.Mission;
import com.budgo.domain.Missions;

public class AnswerChecking {
    private final Missions missions;

    public AnswerChecking(Missions missions) {

        this.missions = missions;
    }

    public boolean isAnswer(int question, String answer) {
        Mission mission = missions.missionList.get(question - 1);
        int answerInt;
        try {
            answerInt = Integer.parseInt(answer);
        } catch (Exception e) {
            return false;
        }

        return answerInt == mission.getRightAnswer();
    }
}
