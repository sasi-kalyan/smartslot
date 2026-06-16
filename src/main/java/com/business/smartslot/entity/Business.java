package com.business.smartslot.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "business")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String address;
    private String city;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private AppUser owner;

    private String openingTime;
    private String closingTime;

    private String createdAt;
    private String updatedAt;
}
