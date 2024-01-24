package com.example.youtubeclonebackend.Payload.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UploadVideoRequest implements Serializable {
    private String title;
    private MultipartFile video;
    private MultipartFile image;
    private List<String> tags;

}
