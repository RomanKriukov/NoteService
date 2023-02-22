package com.kriukov.noteservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "likes")
public class Like {

    @Id
    String id;
    private String noteId;
    private String authorId;

    public Like(String noteId, String authorId){
        this.id = noteId + authorId;
        this.noteId = noteId;
        this.authorId = authorId;
    }
}
