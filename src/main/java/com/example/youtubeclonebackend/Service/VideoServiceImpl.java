package com.example.youtubeclonebackend.Service;

import com.example.youtubeclonebackend.Entities.Video;
import com.example.youtubeclonebackend.Payload.Request.UploadVideoRequest;
import com.example.youtubeclonebackend.Payload.Response.VideosResponse;
import com.example.youtubeclonebackend.Repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final VideoStorageService videoStorageService;
    private final VideoRepository videoRepository;
    private final HistoryService historyService;

    @Override
    public void uploadVideo(UploadVideoRequest uploadVideoRequest) {
        String videoUrl = null;
        String imageUrl = null;
        try {
            videoUrl = videoStorageService.storeFile(uploadVideoRequest.getVideo());
            imageUrl = videoStorageService.storeFile(uploadVideoRequest.getImage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        var video = new Video();
        video.setTitle(uploadVideoRequest.getTitle());
        video.getTags().addAll(uploadVideoRequest.getTags());
        video.setVideoUrl("/uploads/user/" + videoUrl);
        video.setImageUrl("/uploads/user/" + imageUrl);
        video.setUploadDate(LocalDateTime.now());
        videoRepository.save(video);
    }

    @Override
    public Page<VideosResponse> findPaginated(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 3);
        return videoRepository.findAll(pageable).map(VideosResponse::build);
    }

    @Override
    public Page<VideosResponse> searchVideoByTitle(String title, int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 3);
        return videoRepository.findByTitleOrTagsOrPublisher(title, title, title, pageable).map(VideosResponse::build);
    }

    @Override
    public Video getVideo(String videoId, Principal authUser) {
        var video = videoRepository.findById(videoId).orElseThrow();
        historyService.addToHistory(authUser, video.getId());
        return video;
    }

    public Video getVideo(String id) {
        return videoRepository.findById(id).orElseThrow();
    }
}
