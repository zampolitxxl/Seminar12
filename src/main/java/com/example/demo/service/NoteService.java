package com.example.demo.service;

import com.example.demo.Repository.NoteRepository;
import com.example.demo.domain.Note;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.*;


import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

   //Добавление
    public Note addNote(Note note){
        noteRepository.save(note);
        return  note;
    }


    //Возвращаем задачи по статусу. Метод должен использовать технологии JPA
   // public List<Task> findTasksByStatus(TaskStatus status){

     // return taskRepository.findTasksByStatus(status);

    //}

    //Удаление
    public void deleteTaskById(Long id){
        noteRepository.deleteById(id);
    }

    public Note findById(Long id) {
       return  noteRepository.findById(id).orElseThrow(null);
    }


    public Note updateNote(Note note) {
        Note noteById = findById(note.getId());

        noteById.setName(note.getName());
        noteById.setNote(note.getNote());


        return noteRepository.save(noteById);
    }

    public void deleteNote(Long id) {
        Note noteById = findById(id);
        noteRepository.delete(noteById);
    }

    //замена статуса , если не получиться QUERY прописать


   /*
    public void  changeStatus(long id, TaskStatus status){
        taskRepository.changeStatus(id, status);
    }
*/


}
