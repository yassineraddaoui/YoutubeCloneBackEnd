package com.example.youtubeclonebackend.Service.Comment;

import java.security.Principal;

public interface CommentService {
    void comment(String videoId, String text, Principal connectedUser);
    void deleteComment(String videoId,Principal connectedUser,String commentId);
}
