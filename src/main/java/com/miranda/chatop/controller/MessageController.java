package com.miranda.chatop.controller;

import com.miranda.chatop.model.entity.MessageEntity;
import com.miranda.chatop.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/messages")
    public MessageEntity postMessageEntity(@RequestBody MessageEntity messageEntity) {
        return messageService.saveMessageEntity(messageEntity);
    }
}
