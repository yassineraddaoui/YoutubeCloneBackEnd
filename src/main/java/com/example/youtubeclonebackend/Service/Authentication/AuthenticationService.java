package com.example.youtubeclonebackend.Service.Authentication;

import com.example.youtubeclonebackend.Payload.Request.SignUpRequest;

public interface AuthenticationService {

    void signUp(SignUpRequest signUpRequest);
}
