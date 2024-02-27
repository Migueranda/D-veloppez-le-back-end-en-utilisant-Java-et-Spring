package com.miranda.chatop.service;

import com.miranda.chatop.model.dto.UserDto;
import com.miranda.chatop.model.entity.UserEntity;

public interface IUserService {
    UserDto getUserEntity(final Integer id);

    UserDto saveRegisterUserEntity(UserEntity userEntity);

    UserDto saveLoginUser(UserEntity userEntity);
}
