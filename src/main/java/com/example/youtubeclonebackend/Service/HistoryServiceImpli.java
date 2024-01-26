package com.example.youtubeclonebackend.Service;

import com.example.youtubeclonebackend.Entities.History;
import com.example.youtubeclonebackend.Entities.User;
import com.example.youtubeclonebackend.Repository.HistoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpli implements HistoryService{
    private final HistoryRepo historyRepo;
    @Override
    public void addToHistory(Principal connectedUser,String videoId) {
        User authUser = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        var newHistory = History.builder()
                .video(videoId)
                .user(authUser.getId())
                .build();
        historyRepo.save(newHistory);
    }

    @Override
    public List<String> checkHistory(Principal connectedUser) {
        User authUser = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        return historyRepo
                .findByUser(authUser.getId())
                .stream()
                .map(History::getVideo)
                .toList();
    }
}
