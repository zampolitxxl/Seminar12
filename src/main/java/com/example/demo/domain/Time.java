package com.example.demo.domain;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Класс для подсчеа количества задач в коллекции
@Component
public class Time {

    //метод уазывет время суток (утро, день, вечер)
    public void partOfDay(){
       String s = DateTimeFormatter
               .ofPattern("B")
               .format(LocalDateTime.now());
       System.out.println("сейчас "  +  s);


   }


}
