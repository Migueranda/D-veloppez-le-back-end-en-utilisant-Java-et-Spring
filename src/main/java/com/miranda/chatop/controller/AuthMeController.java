package com.miranda.chatop.controller;

import com.miranda.chatop.model.entity.UserEntity;
import com.miranda.chatop.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthMeController {
    private UserService userService;

    @GetMapping("/auth/me")
    public Iterable<UserEntity> getMe(){
        return userService.getMe();
    }
}
