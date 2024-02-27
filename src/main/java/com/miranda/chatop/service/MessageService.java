package com.miranda.chatop.service;

import com.miranda.chatop.model.dto.MessageDto;
import com.miranda.chatop.model.entity.MessageEntity;
import com.miranda.chatop.repository.MessageRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class MessageService implements IMessageService {
    private final MessageRepository messageRepository;
    @Override
    public MessageDto saveMessageEntity(MessageDto messageDto){
        MessageEntity saveMessageEntity = messageRepository.save(new MessageEntity(messageDto));
        return MessageDto.convertToDto(saveMessageEntity);
    }
}
