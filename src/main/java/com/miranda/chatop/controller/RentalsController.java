package com.miranda.chatop.controller;

import com.miranda.chatop.model.dto.RentalsDto;
import com.miranda.chatop.model.entity.RentalsEntity;
import com.miranda.chatop.service.IRentalsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class RentalsController {// exposition des endpoints pour gérer les opérations CRUD
    @Autowired
    private IRentalsService rentalsService;
    @GetMapping("/rentals")//Récupération de la liste de toutes les location disponibles.
        /*public List<RentalsDto> getRentals(){
           return rentalsService.getRentals();
       }*/
    public Map<String, List<RentalsDto>> getRentals(){
        return Map.of("rentals", rentalsService.getRentals());
    }

    @GetMapping("/rentals/{id}")//Récuperation d'une location spécifique en fonction de son identifiant
    public  RentalsDto getRentalsById(@PathVariable Long id){
        return rentalsService.getRentalsEntity(id);
    }
    @PostMapping("/rentals")//Création d'une nouvelle location
    public RentalsDto postRentalsEntity(@RequestBody RentalsDto rentalsDto) {
        return rentalsService.saveRentalsEntity(rentalsDto);
    }
    @PutMapping("/rentals/{id}")// Mise à jour une location existante
    public RentalsDto putRentalsById(@RequestBody RentalsDto rentalsDto, @PathVariable Long id) {
        rentalsDto.setId(id);
        return  rentalsService.saveRentalsEntity(rentalsDto);
    }

}
