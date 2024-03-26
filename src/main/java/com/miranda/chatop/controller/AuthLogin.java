package com.miranda.chatop.controller;

import com.miranda.chatop.model.entity.UserEntity;
import com.miranda.chatop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthLogin {
    @Autowired
    private UserService userService;

    @PostMapping("/auth/login")
    public UserEntity postLoginUser(@RequestBody UserEntity userEntity) {
        return userService.saveLoginUser(userEntity);
    }


}
