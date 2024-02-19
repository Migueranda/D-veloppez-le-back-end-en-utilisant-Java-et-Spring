package com.miranda.chatop.service;

import com.miranda.chatop.model.dto.RentalsDto;
import com.miranda.chatop.model.entity.RentalsEntity;
import com.miranda.chatop.repository.RentalRepository;
import jakarta.persistence.EntityManager;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Data
@Service
public class RentalsService implements IRentalsService{
    //e service RentalsService encapsule les opérations CRUD de base pour les entités RentalsEntity, en utilisant les méthodes fournies par le RentalRepository

    private final RentalRepository rentalRepository;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    public RentalsService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public RentalsEntity getRentalsEntity(final Long id){
        return rentalRepository.findById(id).orElse(null);
    }
    @Override
    public List<RentalsDto> getRentals() {
        Iterable<RentalsEntity> rentalsEntities = rentalRepository.findAll();

        List<RentalsDto> result = StreamSupport.stream(rentalsEntities.spliterator(), false)
                .map(RentalsDto::convertToDto)
                .collect(Collectors.toList());
        return result;
    }
    @Override
    public void deleteRentalsEntity(final Long id){
        rentalRepository.deleteById(id);
    }
    @Override
    public RentalsEntity saveRentalsEntity(RentalsEntity rentalsEntity){
        RentalsEntity saveRentalsEntity = rentalRepository.save(rentalsEntity);
      return saveRentalsEntity;
    }
}
