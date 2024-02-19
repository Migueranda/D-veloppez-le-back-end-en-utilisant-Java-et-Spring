package com.miranda.chatop.service;

import com.miranda.chatop.model.dto.RentalsDto;
import com.miranda.chatop.model.entity.RentalsEntity;
import com.miranda.chatop.model.entity.UserEntity;

import java.util.List;

public interface IRentalsService {
     List<RentalsDto> getRentals();
     RentalsEntity getRentalsEntity(final Long id);
     void deleteRentalsEntity(final Long id);
     RentalsEntity saveRentalsEntity(RentalsEntity rentalsEntity);
}
