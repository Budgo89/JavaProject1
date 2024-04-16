package com.budgo.service;

import com.budgo.domain.Mission;
import com.budgo.domain.Missions;
import org.apache.commons.csv.CSVRecord;


public class CscParser {
    Iterable<CSVRecord> records;
    private Missions mission;

    public CscParser(Iterable<CSVRecord> records) {
        this.records = records;
        mission = new Missions();
        parser();
    }

    private void parser() {
        for (CSVRecord record : records) {
            if (record.get(0).equals("id")) {
                continue;
            }
            mission.missionList.add(new Mission(Integer.parseInt(record.get(0)),
                    record.get(1),
                    Integer.parseInt(record.get(2)),
                    record.get(3),
                    record.get(4),
                    record.get(5)));
        }
    }

    public Missions getMission() {
        return mission;
    }
}
