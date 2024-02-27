package com.miranda.chatop.service;

import com.miranda.chatop.model.dto.RentalsDto;
import com.miranda.chatop.model.entity.RentalsEntity;
import com.miranda.chatop.model.entity.UserEntity;

import java.util.List;

public interface IRentalsService {// l'inversion de contrôle (IoC) :permet de changer facilement l'implémentation du service sans changer le code client.
     List<RentalsDto> getRentals();
     RentalsDto getRentalsEntity(final Long id);
     RentalsDto deleteRentalsEntity(final Long id);
     RentalsDto saveRentalsEntity(RentalsDto rentalsDto);
}
