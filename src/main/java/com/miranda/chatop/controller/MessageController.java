package com.miranda.chatop.controller;

import com.miranda.chatop.model.dto.MessageDto;
import com.miranda.chatop.model.entity.MessageEntity;
import com.miranda.chatop.service.IMessageService;
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
