package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class Mission {

    private Integer id;
    private String question;
    private Integer rightAnswer;
    private Map<Integer, String> answers;

}
