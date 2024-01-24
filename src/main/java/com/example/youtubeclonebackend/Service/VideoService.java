package com.example.youtubeclonebackend.Service;

import com.example.youtubeclonebackend.Payload.Request.UploadVideoRequest;
import com.example.youtubeclonebackend.Payload.Response.VideosResponse;
import org.springframework.data.domain.Page;

public interface VideoService {
    void uploadVideo(UploadVideoRequest uploadVideoRequest);
    Page<VideosResponse> findPaginated(int pageNo);

    Page<VideosResponse> searchVideoByTitle(String name, int pageNo);
}
