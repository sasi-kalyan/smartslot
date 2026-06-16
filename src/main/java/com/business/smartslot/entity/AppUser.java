package com.business.smartslot.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) /* AUTO is portable across databases (Hibernate decides which one to use as per DB's Oracle, Postgres, MySQL)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB generates the ID
    /*@GeneratedValue(strategy = GenerationType.SEQUENCE) // Hibernate prefetches the ID first and then insert */
    private Long id;
    @Column(unique = true, nullable = false)
    private String userName;
    private String password;
    private String fullName;
    @Column(unique = true, nullable = false)
    private String email;
    private String phoneNumber;
    private String createdAt;
    private String updatedAt;
}
