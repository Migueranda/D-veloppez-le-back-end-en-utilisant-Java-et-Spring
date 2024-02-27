package com.miranda.chatop.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.miranda.chatop.model.dto.UserDto;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@Table(name = "users")
public class UserEntity {

    public UserEntity() {
        // Constructeur par défaut sans arguments
    }

    public UserEntity(UserDto userDto){
        Date date = new Date();

        this.setId(userDto.getId());
        this.setName(userDto.getName());
        this.setEmail(userDto.getEmail());
        this.setPassword(userDto.getPassword());
        this.setCreated_at(new Timestamp(date.getTime()));
        this.setUpdated_at(new Timestamp(date.getTime()));
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "CREATED_AT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Timestamp created_at;

    @Column(name = "UPDATED_AT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Timestamp updated_at;

}
