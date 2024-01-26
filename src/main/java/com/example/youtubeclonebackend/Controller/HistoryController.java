package com.example.youtubeclonebackend.Controller;

import com.example.youtubeclonebackend.Payload.Response.VideosResponse;
import com.example.youtubeclonebackend.Service.HistoryService;
import com.example.youtubeclonebackend.Service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/history")
public class HistoryController {
    private final HistoryService historyService;
    private final VideoService videoService;

    @GetMapping
    public ResponseEntity<?> getHistory(Principal principal){
        var history = historyService.checkHistory(principal)
                .stream()
                .map(videoService::getVideo)
                .map(VideosResponse::build)
                .toList();
        return new ResponseEntity<>(history, HttpStatus.OK);
    }

}
