package com.example.youtubeclonebackend.Payload.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignUpRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
