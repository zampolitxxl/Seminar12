package com.example.demo.controller;

import com.example.demo.Repository.NoteRepository;
import com.example.demo.domain.Note;
import com.example.demo.domain.Time;
import com.example.demo.service.Adapter;
import com.example.demo.service.FileGateway;
import com.example.demo.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/notes")
@AllArgsConstructor
public class NoteController {
    private final FileGateway fileGateway;

    private  final NoteService noteService;


    //private  Time time = new Time();

    private Adapter adapter = new Adapter(new Time());




    @GetMapping("/notes")
    public List<Note> getAllNotes(){
        adapter.doSomething();

        return noteService.getAllNotes();
    }

    //1. Добавление заметки. (Подсказка @PostMapping )


    @PostMapping("/createNote")
    public Note  createNote(@RequestBody Note note) {
        fileGateway.writeToFile(note.getName() + ".txt", note.toString());

        return  noteService.addNote(note);
    }

    @GetMapping("/note/{id}")
    public Note getById(@PathVariable("id") Long id) {
        return noteService.findById(id);
    }

    @PutMapping("/notes")
    public Note updateNote(@RequestBody Note note) {
        return noteService.updateNote(note);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        Note note = noteService.findById(id);
        if (note !=null) {
            noteService.deleteNote(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
