package com.example.demo.Repository;

import com.example.demo.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    //public List<Task> findTasksByStatus(TaskStatus status);


    }



