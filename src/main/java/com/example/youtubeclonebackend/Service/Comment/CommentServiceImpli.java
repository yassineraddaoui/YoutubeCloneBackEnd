package com.example.youtubeclonebackend.Service.Comment;

import com.example.youtubeclonebackend.Entities.Comment;
import com.example.youtubeclonebackend.Entities.User;
import com.example.youtubeclonebackend.Repository.CommentRepository;
import com.example.youtubeclonebackend.Repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentServiceImpli implements CommentService {
    private final CommentRepository commentRepository;
    private final VideoRepository videoRepository;
    @Override
    public void comment(String videoId, String text, Principal connectedUser) {
        User authUser = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        var video =videoRepository.findById(videoId).orElseThrow();
        var comment = Comment.builder()
                .disLikeCount(0)
                .likeCount(0)
                .video(video)
                .user(authUser)
                .text(text)
                .commentDate(LocalDateTime.now())
                .build();
        video.comment(comment);
        videoRepository.save(video);
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(String videoId, Principal connectedUser, String commentId) {
        User authUser = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        var video =videoRepository.findById(videoId).orElseThrow();
        var comment = commentRepository.findById(commentId).orElseThrow();
        if(authUser.equals(comment.getUser())) {
            video.deleteComment(comment);
            commentRepository.delete(comment);
        }
    }
}
