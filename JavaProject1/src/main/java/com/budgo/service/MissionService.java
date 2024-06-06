package com.budgo.service;

import com.budgo.domain.Missions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class MissionService {

    private Missions missions = new Missions();
    private final String[] HEADERS = {"id", "question", "rightAnswer", "answer1", "answer2", "answer3"};


    public MissionService(@Value("${csvPath}") String path, CsvReader csvReader, MissionParser missionParser){
        Resource resource = new ClassPathResource(path);

        var reader =  csvReader.csvReader(resource, HEADERS);
        missions = missionParser.parser(reader);
    }

    public Missions getMissions() {
        return missions;
    }
}
