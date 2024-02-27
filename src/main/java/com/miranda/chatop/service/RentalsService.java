package com.miranda.chatop.service;

import com.miranda.chatop.model.dto.RentalsDto;
import com.miranda.chatop.model.entity.RentalsEntity;
import com.miranda.chatop.repository.RentalRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Data
@Service
public class RentalsService implements IRentalsService{
    //le service RentalsService encapsule les opérations CRUD de base pour les entités RentalsEntity, en utilisant les méthodes fournies par le RentalRepository
    // Le service utilise le RentalRepository pour interagir avec la base de données
    private final RentalRepository rentalRepository;
    /*@Autowired*/
   /* private EntityManager entityManager;*/
    @Autowired
    public RentalsService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }
   // Récupération d'une location spécifique en fonction de son id
    /*public RentalsEntity getRentalsEntity(final Long id){
        return rentalRepository.findById(id).orElse(null);
    }*/
   @Override
    public RentalsDto getRentalsEntity(final Long id){
        RentalsEntity rentalsEntity = rentalRepository.findById(id).orElse(null);
       if (rentalsEntity == null) {
           throw new EntityNotFoundException("RentalsEntity not found for id: " + id);
       }
       return RentalsDto.convertToDto(rentalsEntity);
    }
    @Override
    public List<RentalsDto> getRentals() {//Récupération de la liste de toutes les locations disponibles.
        Iterable<RentalsEntity> rentalsEntities = rentalRepository.findAll();
        //utilisation de StreamSupport pour convertir l'itérable de locations en une liste de DTO
        // pour transformer les entités en objets DTO avant de les renvoyer à l'utilisateur.
        List<RentalsDto> result = StreamSupport.stream(rentalsEntities.spliterator(), false)
                .map(RentalsDto::convertToDto)
                .collect(Collectors.toList());
        return result;
    }
    @Override//suppression d'une location spécifique en fonction de son id
    public RentalsDto deleteRentalsEntity(final Long id){
        rentalRepository.deleteById(id);
        return new RentalsDto();
    }
    @Override//Création d'une nouvelle location ou mise à jour d'une location existante.
    public RentalsDto saveRentalsEntity(RentalsDto rentalsDto){
        RentalsEntity saveRentalsEntity = rentalRepository.save(new RentalsEntity(rentalsDto));
      return RentalsDto.convertToDto(saveRentalsEntity);
    }
}
