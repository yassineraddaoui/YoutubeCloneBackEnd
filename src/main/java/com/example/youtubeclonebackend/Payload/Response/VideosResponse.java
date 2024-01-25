package com.example.youtubeclonebackend.Payload.Response;

import com.example.youtubeclonebackend.Entities.Video;
import com.example.youtubeclonebackend.Service.VideoStorageService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VideosResponse implements Serializable {
    //private byte[] video;
    private byte[] image;

    private String channel;
    private String channelUrl;
    private String title;
    private Integer viewsCount;
    private LocalDateTime uploadDate;

    public static VideosResponse build(Video v) {
        try {
            return VideosResponse.builder().title(v.getTitle())
                    //.channel() // name of the channel
         //NO NEED  .video(VideoStorageService.loadFileUser(v.getVideoUrl()).getContentAsByteArray())
                    .image(VideoStorageService.loadFileUser(v.getImageUrl()).getContentAsByteArray())
                    .viewsCount(v.getViewCount().get())
                    .uploadDate(v.getUploadDate())
                    .build();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}