package com.miranda.chatop.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "rentals")
public class RentalsEntity { // réprensente une entité dans ma base de données.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURFACE")
    private Integer surface;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "PICTURE")
    private String picture;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "OWNER_ID")
    private Integer owner_id;


    @Column(name = "CREATED_AT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Timestamp created_at;


    @Column(name = "UPDATED_AT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Timestamp updated_at;
}
