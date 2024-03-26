package com.miranda.chatop.repository;

import com.miranda.chatop.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    public UserEntity findByName(String name);
}

