package com.kriukov.noteservice.controller;

import com.kriukov.noteservice.entity.Like;
import com.kriukov.noteservice.entity.Note;
import com.kriukov.noteservice.service.LikeService;
import com.kriukov.noteservice.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class NoteController {

    @Autowired
    NoteService noteService;
    @Autowired
    LikeService likeService;

    @PostMapping("/createNote")
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        return ResponseEntity.ok(noteService.createNote(note));
    }

    @GetMapping("/getNoteById/{noteId}")
    public ResponseEntity<Note> getNoteById(@PathVariable String noteId){
        Note note = noteService.getNoteById(noteId);

        if(Objects.isNull(note)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(note);
    }

    @GetMapping("/getAllNotes")
    public ResponseEntity<List<Note>> getAllNotes(){
        List<Note> noteList = noteService.getAllNotes();
        if(Objects.isNull(noteList)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(noteList);
    }

    @PutMapping("/updateNote")
    public ResponseEntity<Note> updateNote(@RequestBody Note updateNote){
        Note note = noteService.updateNote(updateNote);
        if(Objects.isNull(note)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(note);
    }

    @DeleteMapping("/deleteNote/{noteId}")
    public ResponseEntity<String> deleteNote(@PathVariable String noteId){
        String result = noteService.deleteNote(noteId);
        if(Objects.isNull(result)){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/likeDislike")
    public ResponseEntity<Note> likeDislike(@RequestBody Like like){
        Note note = likeService.likeDislike(like);
        if(Objects.isNull(note)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(note);
    }
}
