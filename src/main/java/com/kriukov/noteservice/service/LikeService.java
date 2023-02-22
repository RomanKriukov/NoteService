package com.kriukov.noteservice.service;

import com.kriukov.noteservice.entity.Like;
import com.kriukov.noteservice.entity.Note;
import com.kriukov.noteservice.logger.Logger;
import com.kriukov.noteservice.repository.LikeRepository;
import com.kriukov.noteservice.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class LikeService {

    @Autowired
    LikeRepository likeRepository;
    @Autowired
    NoteRepository noteRepository;
    @Autowired
    Logger logger;
    @Autowired
    UserService userService;
    @Autowired
    NoteService noteService;

    public Note likeDislike(Like inputLike){
        if(Objects.isNull(inputLike.getAuthorId())
                || Objects.isNull(inputLike.getNoteId())
                || Objects.isNull(userService.findById(inputLike.getAuthorId()))
                || Objects.isNull(noteService.getNoteById(inputLike.getNoteId()))){
            logger.logMessage("The user or note does not exist!");
            return null;
        }
        Like like = new Like(inputLike.getNoteId(), inputLike.getAuthorId());
        Optional<Like> likeOptional = likeRepository.findById(like.getId());
        if(likeOptional.isEmpty()) {
            likeRepository.insert(like);
        }else{
            likeRepository.delete(like);
        }
        Note note = noteRepository.findById(like.getNoteId()).get();
        note.setLikes(likeRepository.countByNoteId(like.getNoteId()));
        return noteService.updateNote(note);
    }
}
