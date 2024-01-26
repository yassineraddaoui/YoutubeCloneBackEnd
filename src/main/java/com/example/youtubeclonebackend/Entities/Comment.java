package com.example.youtubeclonebackend.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Document(value = "Comment")
public class Comment {

    @Id
    private String id;
    private String text;
    @DBRef
    private User user;
    @DBRef
    private Video video;
    private Integer likeCount;
    private Integer disLikeCount;
    private LocalDateTime commentDate;
}
