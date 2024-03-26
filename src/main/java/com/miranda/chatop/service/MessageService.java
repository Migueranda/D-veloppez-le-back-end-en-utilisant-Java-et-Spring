package com.miranda.chatop.service;

import com.miranda.chatop.model.entity.MessageEntity;
import com.miranda.chatop.repository.MessageRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class MessageService {
    private final MessageRepository messageRepository;
    public MessageEntity saveMessageEntity(MessageEntity messageEntity){
        MessageEntity saveMessageEntity = messageRepository.save(messageEntity);
        return messageEntity;
    }

}
