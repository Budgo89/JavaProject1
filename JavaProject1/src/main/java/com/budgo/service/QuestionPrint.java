package com.budgo.service;

import com.budgo.domain.Mission;
import com.budgo.domain.Missions;


public class QuestionPrint {
    private final Missions missions;

    public QuestionPrint(Missions missions) {
        this.missions = missions;

        printQues();
    }

    private void printQues() {
        for (Mission mission : missions.missionList) {
            System.out.println(mission.getId() + " " + mission.getQuestion());
        }
    }
}
