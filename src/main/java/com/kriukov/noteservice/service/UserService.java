package com.kriukov.noteservice.service;

import com.kriukov.noteservice.entity.User;
import com.kriukov.noteservice.logger.Logger;
import com.kriukov.noteservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    Logger logger;

    public User addUser(User user){
        User checkUser = userRepository.findByLogin(user.getLogin());
        if(Objects.isNull(checkUser)){
            return userRepository.insert(user);
        }else{
            logger.logMessage("User with login = " + user.getLogin() + " already exists");
            return null;
        }
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
