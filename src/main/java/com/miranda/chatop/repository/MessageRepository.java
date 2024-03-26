package com.miranda.chatop.repository;

import com.miranda.chatop.model.entity.MessageEntity;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<MessageEntity, Long> {
    public MessageEntity findByRental(Integer rental);

}
