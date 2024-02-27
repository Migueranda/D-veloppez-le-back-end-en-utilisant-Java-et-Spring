package com.miranda.chatop.controller;

import com.miranda.chatop.model.dto.UserDto;
import com.miranda.chatop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable Integer id){
        return userService.getUserEntity(id);
    }



}
