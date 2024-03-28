package com.miranda.chatop.service;


import com.miranda.chatop.model.entity.UserEntity;
import com.miranda.chatop.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Data
@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Iterable<UserEntity> getRentals(){
        return userRepository.findAll();
    }

    public Iterable<UserEntity> getMe(){
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserEntity(final Integer id){
        return userRepository.findById(id);
    }

    public UserEntity saveRegisterUserEntity(UserEntity userEntity){
        UserEntity saveRegisterUserEntity = userRepository.save(userEntity);
        return saveRegisterUserEntity;
    }
    public UserEntity saveLoginUser(UserEntity userEntity){
        UserEntity saveLoginUser = userRepository.save(userEntity);
        return saveLoginUser;
    }
    
}
