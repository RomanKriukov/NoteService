package com.kriukov.noteservice.service;

import com.kriukov.noteservice.entity.Note;
import com.kriukov.noteservice.logger.Logger;
import com.kriukov.noteservice.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;
    @Autowired
    UserService userService;
    @Autowired
    Logger logger;

    private Optional<Note> noteOptional;

    public Note createNote(Note note){
        if(Objects.isNull(note.getAuthorId())
                || Objects.isNull(userService.findById(note.getAuthorId()))){
            note.setAuthorId(null);
        }
        note.setDateCreation(new Date());
        return noteRepository.insert(note);
    }

    public Note getNoteById(String noteId){
        noteOptional = noteRepository.findById(noteId);
        if(noteOptional.isEmpty()){
            logger.logMessage("Note with such id = " + noteId + " does not exist!");
            return null;
        }
        return noteOptional.get();
    }

    public List<Note> getAllNotes(){
        Sort sort = Sort.by(Sort.Direction.DESC, "dateCreation");
        List<Note> noteList = noteRepository.findAll(sort);
        if(noteList.isEmpty()){
            logger.logMessage("There are no notes yet!");
            return null;
        }
        return noteList;
    }

    public Note updateNote(Note note){
        noteOptional = noteRepository.findById(note.getId());
        if(noteOptional.isEmpty()){
            logger.logMessage("Note with such id = " + note.getId() + " does not exist!");
            return null;
        }
        note.setLastUpdateDate(new Date());
        return noteRepository.save(note);
    }

    public String deleteNote(String noteId){
        noteOptional = noteRepository.findById(noteId);
        if(noteOptional.isEmpty()){
            return "Note with such id = " + noteId + " does not exist!";
        }
        noteRepository.deleteById(noteId);
        return "The note was successfully deleted!";
    }
}
