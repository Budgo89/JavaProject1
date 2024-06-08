package com.example.demo.service;

import com.example.demo.configs.YamlProps;
import com.example.demo.domain.Missions;
import lombok.Getter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class MissionService {

    private final YamlProps props;
    private final CsvReader csvReader;
    private final MissionParser missionParser;

    public MissionService(YamlProps props, CsvReader csvReader, MissionParser missionParser) {
        this.props = props;
        this.csvReader = csvReader;
        this.missionParser = missionParser;
    }

    public Missions getMissions(){
        Resource resource = new ClassPathResource(props.getCsvPath());

        var reader =  csvReader.csvReader(resource, props.getHeaders());

        return missionParser.parser(reader);
    }
}
