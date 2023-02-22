package com.kriukov.noteservice.controller;

import com.kriukov.noteservice.entity.User;
import com.kriukov.noteservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/userAdd")
    public ResponseEntity<User> userAdd(@RequestBody User user){
        User returnUser = userService.addUser(user);
        if(Objects.isNull(returnUser)){
            return ResponseEntity.badRequest().build();
        }else {
            return ResponseEntity.ok(returnUser);
        }
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        User user = userService.findById(userId);
        if(Objects.isNull(user)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getUsers(){
        List<User> userList = userService.getAllUsers();
        if(Objects.isNull(userList)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userList);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User putUser){
        User user = userService.updateUser(putUser);
        if(Objects.isNull(user)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable String userId){
        return userService.deleteUser(userId);
    }
}
