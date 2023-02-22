package com.kriukov.noteservice.controller;

import com.kriukov.noteservice.entity.User;
import com.kriukov.noteservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/userAdd")
    public ResponseEntity<User> userAdd(@RequestBody User user){
        User returnUser = userService.addUser(user);
        if(Objects.isNull(returnUser)){
            return ResponseEntity.badRequest().build();
        }else {
            return ResponseEntity.ok(returnUser);
        }
    }

    @GetMapping("/findAllUsers")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
}
