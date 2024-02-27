package com.miranda.chatop.model.dto;

import com.miranda.chatop.model.entity.MessageEntity;
import com.miranda.chatop.model.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class UserDto {

    private Integer id;
    private String name;
    private String email;
    private String password;
    private Timestamp created_at;
    private Timestamp updated_at;
    public static UserDto convertToDto (UserEntity userEntity){
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setName(userEntity.getName());
        userDto.setEmail(userEntity.getName());
        userDto.setPassword(userEntity.getPassword());
        userDto.setCreated_at(userEntity.getCreated_at());
        userDto.setUpdated_at(userEntity.getUpdated_at());

        return userDto;
    }

}

