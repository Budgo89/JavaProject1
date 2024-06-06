package com.example.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AnswerDTO {
    private String userName;
    private String Surname;
    private List<Answer> answers = new ArrayList<Answer>();
}
