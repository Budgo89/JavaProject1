package com.budgo.service;

import com.budgo.domain.Mission;
import com.budgo.domain.Missions;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

@Component
public class MissionParser {

    public Missions parser(Iterable<CSVRecord> records) {
        Missions mission = new Missions();

        for (CSVRecord record : records) {
            if (record == null) return mission;
            mission.missionList.add(new Mission(Integer.parseInt(record.get("id")),
                    record.get("question"),
                    Integer.parseInt(record.get("rightAnswer")),
                    record.get("answer1"),
                    record.get("answer2"),
                    record.get("answer3")));
        }
        return mission;
    }
}
