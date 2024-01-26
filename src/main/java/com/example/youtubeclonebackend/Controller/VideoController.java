package com.example.youtubeclonebackend.Controller;

import com.example.youtubeclonebackend.Payload.Request.UploadVideoRequest;
import com.example.youtubeclonebackend.Payload.Response.VideoResponse;
import com.example.youtubeclonebackend.Service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/video")
public class VideoController {

    private final VideoService videoService;

    @PostMapping("/upload")
    ResponseEntity<String> uploadVideo(@ModelAttribute UploadVideoRequest uploadVideoRequest) {
        videoService.uploadVideo(uploadVideoRequest);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}")
    ResponseEntity<VideoResponse> getVideo(@PathVariable String id, Principal authUser) {
        var video = videoService.getVideo(id, authUser);
        return new ResponseEntity<>(new VideoResponse(video), HttpStatus.OK);
    }

    @GetMapping("/search/{title}")
    ResponseEntity<?> searchVideo(@PathVariable String title,
                                  @RequestParam(defaultValue = "0", name = "page") int pageNo) {
        return new ResponseEntity<>(videoService.searchVideoByTitle(title, pageNo).getContent(), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<?> getVideos(@RequestParam(defaultValue = "0", name = "page") int pageNo) {
        return new ResponseEntity<>(videoService.findPaginated(pageNo), HttpStatus.OK);
    }

    @PostMapping("/like/{videoId}")
    void likeVideo(@PathVariable String videoId,Principal principal) {
        videoService.likeVideo(videoId,principal);
    }
    @PostMapping("/dislike/{videoId}")
    void dislikeVideo(@PathVariable String videoId,Principal principal) {
        videoService.dislikeVideo(videoId,principal);
    }

}
