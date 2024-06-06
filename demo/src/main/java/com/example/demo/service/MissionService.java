package com.example.demo.service;

import com.example.demo.configs.YamlProps;
import com.example.demo.domain.Missions;
import lombok.Getter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class MissionService {

    @Getter
    private Missions missions = new Missions();

    public MissionService(YamlProps props, CsvReader csvReader, MissionParser missionParser){
        Resource resource = new ClassPathResource(props.getCsvPath());

        var reader =  csvReader.csvReader(resource, props.getHeaders());
        missions = missionParser.parser(reader);
    }
}
