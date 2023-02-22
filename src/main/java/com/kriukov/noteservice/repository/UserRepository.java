package com.kriukov.noteservice.repository;

import com.kriukov.noteservice.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByLogin(String name);
}
