package com.budgo.service;

import com.budgo.domain.Mission;
import com.budgo.domain.Missions;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CscParser {

    public CscParser(CsvReader csvrecords, @Qualifier("missions") Missions mission) {
        parser(csvrecords.getRecords(), mission);
    }

    private void parser(Iterable<CSVRecord> records, Missions mission) {
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
}
