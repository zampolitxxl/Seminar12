package com.example.demo.service;

import com.example.demo.domain.Time;
import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class Adapter implements  TimeLibraryHelper{

    private Time time;

    public Adapter(Time time){
        this.time = time;
    }
    @Override
    public void doSomething() {

        time.partOfDay();

    }
}
