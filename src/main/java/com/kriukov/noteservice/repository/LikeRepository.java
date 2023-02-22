package com.kriukov.noteservice.repository;

import com.kriukov.noteservice.entity.Like;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LikeRepository extends MongoRepository<Like, String> {

    public Like findByNoteId(String noteId);
}
