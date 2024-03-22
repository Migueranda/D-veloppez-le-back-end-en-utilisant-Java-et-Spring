package com.miranda.chatop.controllers;

import com.miranda.chatop.model.dtos.MessageDto;
import com.miranda.chatop.services.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {
    @Autowired
    private IMessageService messageService;

    @PostMapping("/messages")
    public MessageDto postMessageEntity(@RequestBody MessageDto messageDto) {
        return messageService.saveMessageEntity(messageDto);
    }
}
