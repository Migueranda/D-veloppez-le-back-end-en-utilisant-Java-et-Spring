package com.miranda.chatop.service;

import com.miranda.chatop.model.dto.MessageDto;
import com.miranda.chatop.model.entity.MessageEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IMessageService {
    MessageDto saveMessageEntity(MessageDto messageDto);
}
