package com.kriukov.noteservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class NoteDto {

    private String id;
    private String content;
    private String author;
    private Date dateCreation;
    private int likes;
}
