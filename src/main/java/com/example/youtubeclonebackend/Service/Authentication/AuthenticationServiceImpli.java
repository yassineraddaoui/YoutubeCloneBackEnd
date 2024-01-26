package com.example.youtubeclonebackend.Service.Authentication;

import com.example.youtubeclonebackend.Entities.User;
import com.example.youtubeclonebackend.Payload.Request.SignUpRequest;
import com.example.youtubeclonebackend.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpli implements AuthenticationService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void signUp(SignUpRequest signUpRequest) {

        var createdUser = User.builder()
                .firstName(signUpRequest.getFirstname())
                .lastName(signUpRequest.getLastname())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .emailAddress(signUpRequest.getEmail())
                .build();
        userRepository.save(createdUser);
    }
}
