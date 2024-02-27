package com.miranda.chatop.service;


import com.miranda.chatop.model.dto.UserDto;
import com.miranda.chatop.model.entity.UserEntity;
import com.miranda.chatop.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserService implements IUserService{

    private final UserRepository userRepository;
    /*@Autowired
    private EntityManager entityManager;*/
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Iterable<UserEntity> getUser(){
        return userRepository.findAll();
    }

    public Iterable <UserEntity> getMe(){
        return  userRepository.findAll();
    }
    @Override
    public UserDto getUserEntity(final Integer id){
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity == null) {
            // Handle the case where entity is not found (throw exception or return appropriate response)
            // For example, you can throw a custom exception or return a ResponseEntity with an error message.
            throw new EntityNotFoundException("UserEntity not found for id: " + id);
        }
        return UserDto.convertToDto(userEntity);
    }
   /*public UserDto getUserDto(Integer id) {
        UserEntity userEntity = getUserEntity(id);
        return (userEntity != null) ? UserDto.convertToDto(userEntity) : null;
    }*/
    @Override
    public UserDto saveRegisterUserEntity(UserEntity userEntity){
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return UserDto.convertToDto(savedUserEntity);
    }
    @Override
    public UserDto saveLoginUser(UserEntity userEntity){
        UserEntity savedUserEntity  = userRepository.save(userEntity);
        return UserDto.convertToDto(savedUserEntity );
    }
}
