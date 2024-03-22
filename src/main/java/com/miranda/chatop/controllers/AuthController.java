package com.miranda.chatop.controllers;

import com.miranda.chatop.configuration.UserAuthProvider;
import com.miranda.chatop.model.dtos.SignUpDto;
import com.miranda.chatop.model.dtos.CredentialsDto;
import com.miranda.chatop.model.dtos.UserDto;
import com.miranda.chatop.services.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final UserService userService;
    private final UserAuthProvider userAuthProvider;

    @PostMapping("auth/login")
    public ResponseEntity<UserDto> login(@RequestBody CredentialsDto credentialsDto) {
       // System.out.println("Received login request for email: " + credentialsDto.email());
        UserDto user = userService.login(credentialsDto);

        user.setToken(userAuthProvider.createToken(user));
        return ResponseEntity.ok(user);
    }

    @GetMapping("auth/me")
    public ResponseEntity<UserDto> getCurrentUser(){
        UserDto currentUser = userService.getCurrentUser();

        return ResponseEntity.ok(currentUser);
    }
    @PostMapping("auth/register")
    public ResponseEntity<UserDto> register(@RequestBody SignUpDto signUpDto) {
        UserDto user = userService.register(signUpDto);

        user.setToken(userAuthProvider.createToken(user));
        return ResponseEntity.created(URI.create("/user/" + user.getId())).body(user);
    }
}
