package com.miranda.chatop.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Entity
@Data
@Table(name = "messages")
public class MessageEntity {

    //private Integer id;
    @Setter
    @Getter
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RENTAL_ID")
    private Integer rental;

    @Column(name = "USER_ID")
    private Integer user_id;

    @Column(name = "MESSAGE")
    private String message  ;

    @Column(name = "CREATED_AT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Timestamp created_at;

    @Column(name = "UPDATED_AT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Timestamp updated_at;
}
