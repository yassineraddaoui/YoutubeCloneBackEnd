package com.example.youtubeclonebackend.Repository;

import com.example.youtubeclonebackend.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByEmailAddress(String username);
}
