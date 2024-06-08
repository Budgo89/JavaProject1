package com.example.demo.controllers;

import com.example.demo.mappers.MissionMapper;
import com.example.demo.configs.YamlProps;
import com.example.demo.domain.Missions;
import com.example.demo.domain.Student;
import com.example.demo.dto.AnswerDTO;
import com.example.demo.dto.MissionDTO;
import com.example.demo.service.AnswerChecking;
import com.example.demo.service.MissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class QuestionController {
    public final MissionMapper missionMapper;
    private final AnswerChecking answerChecking;
    private final MessageSource messageSource;
    private final YamlProps props;
    MissionService missionService;

    public QuestionController(MissionService missionService, MissionMapper missionMapper,
                              AnswerChecking answerChecking, MessageSource messageSource,
                              YamlProps props) {
        this.missionService = missionService;
        this.missionMapper = missionMapper;
        this.answerChecking = answerChecking;
        this.messageSource = messageSource;
        this.props = props;
    }

    @GetMapping("/questions")
    public List<MissionDTO> getQuestions(){

        List<MissionDTO> missionsDTO = new ArrayList<>();
        var missions = missionService.getMissions();

        for (var mission : missions.missionList){
            missionsDTO.add(missionMapper.missionToMissionDTO(mission));
        }

        return missionsDTO;
    }

    @PostMapping("/answer")
    public String setAnswer(@RequestBody AnswerDTO answerDTO){
        log.info(answerDTO.toString());
        Student student = answerChecking.checkingAnswer(answerDTO);
        var message1 = messageSource.getMessage("student.hallo",
                new String[] {student.getSurname() + " " + student.getName()}, props.getLocale());

        var message2 = messageSource.getMessage("student.result",new String[] {String.valueOf(student.getCorrectAnswer())}, props.getLocale());

        return message1 + message2;
    }

    private Logger log = LoggerFactory.getLogger(QuestionController.class);
}
