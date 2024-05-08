package com.example.demo.domain;

import com.example.demo.Repository.NoteRepository;
import com.example.demo.service.NoteService;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

import static java.time.LocalDateTime.*;



@Entity
@Data
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String note;
    @Column(nullable = false)
    private LocalDateTime data = now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }




 /*
    public Task(Long id, String taskName) {
        this.id = id;
        this.taskName = taskName;
      //  this.dateTimeCreation = LocalDateTime.now();
       // this.status= NOT_STARTED;
    }

     */
}
