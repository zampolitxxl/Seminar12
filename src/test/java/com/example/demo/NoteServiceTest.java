/*
package com.example.demo;

import com.example.demo.Repository.NoteRepository;
import com.example.demo.domain.Note;
import com.example.demo.service.NoteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class NoteServiceTest {

    @Mock
    public NoteRepository noteRepository;

    @InjectMocks
    public NoteService noteService;

    @Test
    public void addNoteTest(){

        Note testNote = new Note();
        testNote.setName("TestNote");
        testNote.setNote("Test");

        given(noteRepository.findById(testNote.getId())).willReturn(Optional.of(testNote));

        noteRepository.save(testNote);

        verify(noteRepository).save(testNote);


    }


}
