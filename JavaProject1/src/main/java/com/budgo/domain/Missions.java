package com.budgo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Missions {

    public List<Mission> missionList;

    public Missions() {
        missionList = new ArrayList<>();
    }
}
