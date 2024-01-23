package com.example.youtubeclonebackend.Service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class VideoStorageService {
    private final Path rootPicturesUser = Paths.get("uploads/video/user/");

    public void init() {
        try {
            Files.createDirectories(rootPicturesUser);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload", e);
        }
    }

    public String storeVideo(MultipartFile file) throws IOException {
        try {
            String originalFilename = file.getOriginalFilename();
            String uniqueFilename = generateUniqueFilename(originalFilename);
            Files.copy(file.getInputStream(), rootPicturesUser.resolve(uniqueFilename));
            return rootPicturesUser+uniqueFilename;
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
    public Resource loadVideoUser(String filename) {
        try {
            Path file = rootPicturesUser.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    private String generateUniqueFilename(String originalFilename) {
        long timestamp = System.currentTimeMillis();
        String fileExtension = StringUtils.getFilenameExtension(originalFilename);
        return "video_" + timestamp + (StringUtils.hasText(fileExtension) ? "." + fileExtension : "");
    }

}
