package com.example.youtubeclonebackend.Controller;

import com.example.youtubeclonebackend.Payload.Request.CommentAddRequest;
import com.example.youtubeclonebackend.Service.Comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/add")
    public ResponseEntity<String> addComment(
            @RequestParam(name = "id",required = true) String videoId,
            @RequestBody CommentAddRequest commentAddRequest,
            Principal connectedUser
    ) {
        commentService.comment(videoId, commentAddRequest.getText(), connectedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body("Comment added successfully");
    }

    @DeleteMapping("/delete/{videoId}/{commentId}")
    public ResponseEntity<String> deleteComment(
            @PathVariable String videoId,
            Principal connectedUser,
            @PathVariable String commentId
    ) {
        commentService.deleteComment(videoId, connectedUser, commentId);
        return ResponseEntity.status(HttpStatus.OK).body("Comment deleted successfully");
    }
}
