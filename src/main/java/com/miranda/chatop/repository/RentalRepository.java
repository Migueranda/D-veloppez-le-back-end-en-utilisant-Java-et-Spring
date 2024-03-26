package com.miranda.chatop.repository;

import com.miranda.chatop.model.entity.RentalsEntity;
import org.springframework.data.repository.CrudRepository;

// fournit des méthodes CRUD (Create, Read, Update, Delete) de base pour interagir avec la base de données.

public interface RentalRepository extends CrudRepository<RentalsEntity, Long> {
    public RentalsEntity findByName(String name);
}
