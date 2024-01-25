package com.example.youtubeclonebackend.Repository;

import com.example.youtubeclonebackend.Entities.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends MongoRepository<Video,Long> {

    Page<Video> findByTitleOrTagsOrPublisher(String title,String tag,String publisher,Pageable pageable);
}
