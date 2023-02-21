package com.kriukov.noteservice.repository;

import com.kriukov.noteservice.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Users, Integer> {

}
