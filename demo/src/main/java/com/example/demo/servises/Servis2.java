package com.example.demo.servises;

import org.springframework.stereotype.Service;

@Service
public class Servis2 {
    private final Servis1 servis1;

    public Servis2(Servis1 servis1){

        this.servis1 = servis1;
    }
}
