package com.business.smartslot.converter;

import com.business.smartslot.dto.AppUserDTO;
import com.business.smartslot.entity.AppUser;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class AppUserConverter {

    public AppUser convertDTOtoEntity(AppUserDTO appUserDto){

        AppUser appUser = new AppUser();
        appUser.setRole(appUserDto.getRole());
        appUser.setUserName(appUserDto.getUserName());
        appUser.setEmail(appUserDto.getEmail());
        appUser.setFullName(appUserDto.getFullName());
        appUser.setPhoneNumber(appUserDto.getPhoneNumber());
        appUser.setPassword(appUserDto.getPassword());
        appUser.setCreatedAt(getFormattedTime());
        appUser.setUpdatedAt(getFormattedTime());

        return appUser;
    }

    public AppUserDTO convertEntitytoDTO(AppUser appUser){

        AppUserDTO appUserDto = new AppUserDTO();
        appUserDto.setId(appUser.getId());
        appUserDto.setRole(appUser.getRole());
        appUserDto.setUserName(appUser.getUserName());
        appUserDto.setEmail(appUser.getEmail());
        appUserDto.setFullName(appUser.getFullName());
        appUserDto.setPhoneNumber(appUser.getPhoneNumber());
        appUserDto.setCreatedAt(appUser.getCreatedAt());
        appUserDto.setUpdatedAt(appUser.getUpdatedAt());

        return appUserDto;
    }

    public String getFormattedTime(){
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDateTime = ldt.format(dtf);
        return formattedDateTime;
    }
}
