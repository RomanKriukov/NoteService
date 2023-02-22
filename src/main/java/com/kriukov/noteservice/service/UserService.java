package com.kriukov.noteservice.service;

import com.kriukov.noteservice.entity.User;
import com.kriukov.noteservice.logger.Logger;
import com.kriukov.noteservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    Logger logger;

    Optional<User> userOptional;

    public User addUser(User user){
        User checkUser = userRepository.findByLogin(user.getLogin());
        if(Objects.isNull(checkUser)){
            user.setDateCreation(new Date());
            return userRepository.insert(user);
        }
        logger.logMessage("User with login = " + user.getLogin() + " already exists!");
        return null;
    }

    public User findById(String userId){
        userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            return null;
        }
        return userOptional.get();
    }

    public List<User> getAllUsers(){
        List<User> userList = userRepository.findAll();
        if(userList.isEmpty()){
            logger.logMessage("There are no users yet!");
            return null;
        }
        return userList;
    }

    public User updateUser(User user){
        userOptional = userRepository.findById(user.getId());
        if(userOptional.isEmpty()){
            logger.logMessage("User with such id = " + user.getId() + " does not exist!");
            return null;
        }
        return userRepository.save(user);
    }

    public String deleteUser(String userId){
        userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            return "User with such id = " + userId + " does not exist!";
        }
        userRepository.deleteById(userId);
        return "The user was successfully deleted!";
    }
}
