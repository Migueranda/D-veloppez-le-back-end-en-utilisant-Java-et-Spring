package com.miranda.chatop.controller;


import com.miranda.chatop.model.entity.UserEntity;
import com.miranda.chatop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthRegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("/auth/register")
    public UserEntity postRegisterUserEntity(@RequestBody UserEntity userEntity) {
        return userService.saveRegisterUserEntity(userEntity);
    }
}
