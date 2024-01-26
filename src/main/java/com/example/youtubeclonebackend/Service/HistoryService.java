package com.example.youtubeclonebackend.Service;

import java.security.Principal;
import java.util.List;

public interface HistoryService {
    void addToHistory(Principal connectedUser ,String videoId);
    List<String> checkHistory(Principal connectedUser);

}
