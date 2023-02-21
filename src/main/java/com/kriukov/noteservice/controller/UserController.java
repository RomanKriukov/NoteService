package com.kriukov.noteservice.controller;

import com.kriukov.noteservice.entity.Users;
import com.kriukov.noteservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/findAllUsers")
    public List<Users> getUsers(){
        return mongoTemplate.findAll(Users.class);
    }
}
