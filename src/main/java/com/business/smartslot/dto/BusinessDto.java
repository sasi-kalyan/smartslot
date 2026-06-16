package com.business.smartslot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessDto {
    private Long id;
    private String name;
    private String description;
    private String address;
    private String city;

    private Long ownerId;
    private String openingTime;
    private String closingTime;

    private String createdAt;
    private String updatedAt;
}
