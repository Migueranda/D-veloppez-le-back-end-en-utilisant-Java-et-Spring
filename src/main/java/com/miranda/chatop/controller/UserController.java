package com.miranda.chatop.controller;

import com.miranda.chatop.model.entity.UserEntity;
import com.miranda.chatop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public Optional<UserEntity> getUserById(@PathVariable Integer id){
        return userService.getUserEntity(id);
    }



}
