package com.example.demo.service;

import com.example.demo.domain.Mission;
import com.example.demo.domain.Missions;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MissionParser {

    public Missions parser(Iterable<CSVRecord> records) {
        Missions mission = new Missions();

        for (CSVRecord record : records) {
            if (record == null) return mission;
            mission.missionList.add(buildMission(record));
        }
        return mission;
    }

    private Mission buildMission(CSVRecord record){
        var id = Integer.parseInt(record.get("id"));
        var question = record.get("question");
        var rightAnswer = Integer.parseInt(record.get("rightAnswer"));
        var answers = buildAnswerMap(record.get("answer1"), record.get("answer2"),record.get("answer3"));

        return new Mission(id, question, rightAnswer, answers);
    }

    private Map<Integer, String> buildAnswerMap(String answer1, String answer2, String answer3) {
        var answers = new HashMap<Integer, String>();
        answers.put(1, answer1);
       answers.put(2, answer2);
       answers.put(3, answer3);
       return answers;
    }
}
