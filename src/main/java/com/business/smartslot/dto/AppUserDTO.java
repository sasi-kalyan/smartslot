package com.business.smartslot.dto;

import com.business.smartslot.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppUserDTO {
    private Long id;
    private Role role;
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String createdAt;
    private String updatedAt;
}
