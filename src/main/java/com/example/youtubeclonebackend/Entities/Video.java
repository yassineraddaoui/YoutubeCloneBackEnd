package com.example.youtubeclonebackend.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(value = "video")
public class Video {
    @Id
    private String id;
    private String title;
    private Long publisher;
    private Set<String> tags=new HashSet<>();
    private List<Comment> commentList = new CopyOnWriteArrayList<>();
    private LocalDateTime uploadDate;
    private String videoUrl;
    private String imageUrl;
    private AtomicInteger likes = new AtomicInteger(0);
    private AtomicInteger disLikes = new AtomicInteger(0);
    private AtomicInteger viewCount = new AtomicInteger(0);

    public void like(){
        likes.incrementAndGet();
    }
    public void undoLike(){
        likes.decrementAndGet();
    }
    public void dislike(){
        disLikes.incrementAndGet();
    }

    public void undoDislike(){
        disLikes.decrementAndGet();
    }
    public void incrementViewCount(){
        viewCount.incrementAndGet();
    }
    public void comment(Comment comment){
        commentList.add(comment);
    }
}
