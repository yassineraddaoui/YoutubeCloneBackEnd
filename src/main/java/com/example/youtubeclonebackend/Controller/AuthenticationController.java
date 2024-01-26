package com.example.youtubeclonebackend.Controller;

import com.example.youtubeclonebackend.Payload.Request.SignUpRequest;
import com.example.youtubeclonebackend.Service.Authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest){
        authenticationService.signUp(signUpRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
