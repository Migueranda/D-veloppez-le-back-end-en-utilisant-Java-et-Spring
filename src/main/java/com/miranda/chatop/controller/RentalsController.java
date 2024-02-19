package com.miranda.chatop.controller;

import com.miranda.chatop.model.dto.RentalsDto;
import com.miranda.chatop.model.entity.RentalsEntity;
import com.miranda.chatop.service.IRentalsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentalsController {//ce contrôleur expose une API REST
    @Autowired
    private IRentalsService rentalsService;
   @GetMapping("/rentals")
    public List<RentalsDto> getRentals(){
       return rentalsService.getRentals();
   }
    @GetMapping("/rentals/{id}")
    public RentalsEntity getRentalsById(@PathVariable Long id){
        return rentalsService.getRentalsEntity(id);
    }
    @PostMapping("/rentals")
    public RentalsEntity postRentalsEntity(@RequestBody RentalsEntity rentalsEntity) {
        return rentalsService.saveRentalsEntity(rentalsEntity);
    }
    @PutMapping("/rentals/{id}")
    public RentalsEntity putRentalsById(@RequestBody RentalsEntity rentalsEntity, @PathVariable Long id) {
        rentalsEntity.setId(id);
        return  rentalsService.saveRentalsEntity(rentalsEntity);
    }

}
