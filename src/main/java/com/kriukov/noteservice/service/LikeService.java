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

    public NoteDto likeDislike(Like like){
        if(Objects.isNull(userService.findById(like.getAuthorId()))
                || Objects.isNull(noteService.getNoteById(like.getNoteId()))){
            logger.logMessage("The user or note does not exist!");
            return null;
        }
        //like.setId();
        Like isExistLike = likeRepository.save(like);
        if(isExistLike.equals(like)){
            likeRepository.delete(like);
            return noteService.getNoteById(like.getNoteId());
        }
        likeRepository.insert(like);
        return noteService.getNoteById(like.getNoteId());
    }
}
