package com.example.youtubeclonebackend.Payload.Response;

import com.example.youtubeclonebackend.Entities.Comment;
import com.example.youtubeclonebackend.Entities.Video;
import com.example.youtubeclonebackend.Service.VideoStorageService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VideoResponse {

    private byte[] video;
    private String id;
    private String title;
    private String publisher;
    private Integer likes;
    private Integer dislikes;
    private Integer viewsCount;
    private List<Comment> comments;
    private LocalDateTime uploadDate;

    public VideoResponse(Video v){
        this.id=v.getId();
        try {
            this.video= VideoStorageService.loadFileUser(v.getVideoUrl()).getContentAsByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.uploadDate=v.getUploadDate();
        this.title=v.getTitle();
        this.dislikes=v.getDisLikes().get();
        this.likes=v.getLikes().get();
        this.viewsCount=v.getViewCount().get();
        this.comments=v.getCommentList()
                .stream()
                .limit(10)
                .toList();
        this.publisher=v.getPublisher();
    }
}
