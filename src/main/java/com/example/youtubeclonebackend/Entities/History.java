package com.example.youtubeclonebackend.Entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "History")
@Builder
@Data
public class History {
    @Id
    private String id;
    private String user;
    private String video;
}
