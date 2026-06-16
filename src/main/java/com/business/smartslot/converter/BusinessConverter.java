package com.business.smartslot.converter;

import com.business.smartslot.dto.BusinessDto;
import com.business.smartslot.entity.AppUser;
import com.business.smartslot.entity.Business;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class BusinessConverter {

    public Business convertBusinessDtoToEnitity(BusinessDto businessDto, AppUser appUser) {

        Business business = new Business();

        business.setOwner(appUser);
        business.setName(businessDto.getName());
        business.setDescription(businessDto.getDescription());
        business.setAddress(businessDto.getAddress());
        business.setCity(businessDto.getCity());
        business.setOpeningTime(businessDto.getOpeningTime());
        business.setClosingTime(businessDto.getClosingTime());
        business.setCreatedAt(getFormattedTime());
        business.setUpdatedAt(getFormattedTime());

        return business;
    }

    public BusinessDto convertBusinessEntityToDto(Business business){

        BusinessDto businessDto = new BusinessDto();

        businessDto.setName(business.getName());
        businessDto.setDescription(business.getDescription());
        businessDto.setAddress(business.getAddress());
        businessDto.setCity(business.getCity());
        businessDto.setOpeningTime(business.getOpeningTime());
        businessDto.setClosingTime(business.getClosingTime());
        businessDto.setCreatedAt(business.getCreatedAt());
        businessDto.setUpdatedAt(business.getUpdatedAt());

        return businessDto;
    }

    public String getFormattedTime(){
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDateTime = ldt.format(dtf);
        return formattedDateTime;
    }
}
