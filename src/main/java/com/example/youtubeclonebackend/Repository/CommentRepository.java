package com.example.youtubeclonebackend.Repository;

import com.example.youtubeclonebackend.Entities.Comment;
import com.example.youtubeclonebackend.Entities.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,String> {
    Page<Comment> findByVideo(Video v, Pageable pageable);
}
