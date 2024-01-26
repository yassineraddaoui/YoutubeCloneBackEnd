package com.example.youtubeclonebackend.Repository;

import com.example.youtubeclonebackend.Entities.History;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HistoryRepo extends MongoRepository<History,String> {
    List<History> findByUser(String userId);
}
