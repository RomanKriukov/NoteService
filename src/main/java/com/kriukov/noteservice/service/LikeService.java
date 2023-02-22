package com.kriukov.noteservice.service;

import com.kriukov.noteservice.dto.NoteDto;
import com.kriukov.noteservice.entity.Like;
import com.kriukov.noteservice.logger.Logger;
import com.kriukov.noteservice.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LikeService {

    @Autowired
    LikeRepository likeRepository;
    @Autowired
    Logger logger;
    @Autowired
    UserService userService;
    @Autowired
    NoteService noteService;

    //public NoteDto likeDislike(String authorId, String noteId){
    //    if(Objects.isNull(userService.findById(authorId)) || Objects.isNull(noteService.getNoteById(noteId))){
    //        logger.logMessage("The user or note does not exist!");
    //        return null;
    //    }
    //    Like like = likeRepository.
    //}
}
