package com.example.demo.controllers;

import com.example.demo.dto.AnswerDTO;
import com.example.demo.dto.QuestionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class QuestionController {

    @Value("${test}")
    private String test;


    @GetMapping("/questions")
    public List<QuestionDTO> getQuestions(){
        log.info(test);
        return List.of(
                new QuestionDTO("Вопрос",List.of("Ответ1","Ответ2"))
        );
    }

    @PostMapping("/answer")
    public String setAnswer(@RequestBody AnswerDTO answerDTO){
        log.info(answerDTO.toString());
        return "sss";
    }

    private Logger log = LoggerFactory.getLogger(QuestionController.class);
}
