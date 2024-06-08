package com.example.demo.dto;

import lombok.Data;

import java.util.Map;

@Data
public class MissionDTO {
    private int id;
    private String question;
    private Map<Integer, String> answers;
}
