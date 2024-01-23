package com.example.youtubeclonebackend;

import com.example.youtubeclonebackend.Service.VideoStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YoutubeCloneBackEndApplication implements CommandLineRunner {

    @Autowired
    private VideoStorageService videoStorageService;

    public static void main(String[] args) {
        SpringApplication.run(YoutubeCloneBackEndApplication.class, args);
    }
    @Override
    public void run(String... args)  {
        videoStorageService.init();
    }


}
