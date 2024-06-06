package com.example.demo.dto;

import lombok.Data;

import java.util.HashMap;

@Data
public class MissionDTO {
    private int id;
    private String question;
    private HashMap<Integer, String> answers;
}
