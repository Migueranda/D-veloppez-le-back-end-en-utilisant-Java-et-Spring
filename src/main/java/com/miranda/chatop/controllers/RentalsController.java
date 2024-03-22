package com.miranda.chatop.controllers;

import com.miranda.chatop.model.dtos.RentalsDto;
import com.miranda.chatop.model.dtos.UserDto;
import com.miranda.chatop.services.IRentalsService;
import com.miranda.chatop.services.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RentalsController {// exposition des endpoints pour gérer les opérations CRUD
    @Autowired
    private UserService userService;
    @Autowired
    private IRentalsService rentalsService;
    @Value("${file.upload.dir}")
    private String uploadDir;

    @GetMapping("/rentals")//Récupération de la liste de toutes les location disponibles.
    public Map<String, List<RentalsDto>> getRentals(){
        return Map.of("rentals", rentalsService.getRentals());
    }

    @GetMapping("/rentals/{id}")//Récuperation d'une location spécifique en fonction de son identifiant
    public  RentalsDto getRentalsById(@PathVariable Long id){
        return rentalsService.getRentalsEntity(id);
    }

    @PostMapping(value = "/rentals", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public RentalsDto postRentalsEntity(@RequestParam("picture") MultipartFile file, @RequestParam("name") String name, @RequestParam("surface") Integer surface, @RequestParam("price") Integer price, @RequestParam("description") String description) throws IOException {

        // Upload
        String uploadDir = "C:\\dev\\Projet3\\chatop\\uploads\\";
        String originalFilename = file.getOriginalFilename();
       // String fileName = System.currentTimeMillis() + "_" + originalFilename;
        File destFile = new File(uploadDir + File.separator + originalFilename );
        file.transferTo(destFile);

        // récupération de l'Id du user authentifié pour set le owner_id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = (UserDto) authentication.getPrincipal();

        // Set rentals DTO
        RentalsDto rentalsDto = new RentalsDto();
        rentalsDto.setName(name);
        rentalsDto.setSurface(surface);
        rentalsDto.setPrice(price);
        rentalsDto.setDescription(description);
        rentalsDto.setPicture(originalFilename);
        rentalsDto.setOwner_id(userDto.getId());

        return rentalsService.saveRentalsEntity(rentalsDto);
    }

    @PutMapping("/rentals/{id}")// Mise à jour une location existante
    public RentalsDto putRentalsById(@RequestParam("name") String name, @RequestParam("surface") Integer surface, @RequestParam("price") Integer price, @RequestParam("description") String description, @PathVariable Long id) throws IOException {
        RentalsDto rentalsDto = new RentalsDto();
        rentalsDto.setId(id);
        rentalsDto.setName(name);
        rentalsDto.setSurface(surface);
        rentalsDto.setPrice(price);
        rentalsDto.setDescription(description);

        return  rentalsService.upDateRentals(rentalsDto);
    }
    @GetMapping("/fileSystem/{picture}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String picture) throws IOException{
        System.out.println("Nom de fichier reçu dans la méthode downloadImageFromFileSystem : " + picture);

        byte[]  imageData = rentalsService.downloadImageFromFileSystem(picture);
        return ResponseEntity.status(HttpStatus.OK)
        .body(imageData);
    }
}
