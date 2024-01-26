package com.example.youtubeclonebackend.Service;

import com.example.youtubeclonebackend.Entities.Video;
import com.example.youtubeclonebackend.Payload.Request.UploadVideoRequest;
import com.example.youtubeclonebackend.Payload.Response.VideosResponse;
import org.springframework.data.domain.Page;

import java.security.Principal;

public interface VideoService {
    void uploadVideo(UploadVideoRequest uploadVideoRequest);
    Page<VideosResponse> findPaginated(int pageNo);

    Page<VideosResponse> searchVideoByTitle(String name, int pageNo);

    Video getVideo(String id, Principal authUser);
    Video getVideo(String id);

    void likeVideo(String videoId, Principal principal);
    void dislikeVideo(String videoId, Principal connectedUser);
}
