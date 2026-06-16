package com.business.smartslot.service.impl;

import com.business.smartslot.converter.BusinessConverter;
import com.business.smartslot.dto.BusinessDto;
import com.business.smartslot.entity.AppUser;
import com.business.smartslot.entity.Business;
import com.business.smartslot.entity.Role;
import com.business.smartslot.exception.BusinessException;
import com.business.smartslot.exception.ErrorModel;
import com.business.smartslot.repository.AppUserRepository;
import com.business.smartslot.repository.BusinessRepository;
import com.business.smartslot.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    public BusinessConverter businessConverter;

    @Autowired
    public BusinessRepository businessRepository;

    @Autowired
    public AppUserRepository appUserRepository;

    @Override
    public BusinessDto registerBusiness(BusinessDto businessDto) throws BusinessException {

        Optional<AppUser> optAppUser = appUserRepository.findById(businessDto.getOwnerId());
        AppUser appUser = optAppUser.get();

        if (optAppUser.isPresent() && appUser.getRole().equals(Role.BUSINESS_OWNER)) {

            Business business = businessConverter.convertBusinessDtoToEnitity(businessDto, appUser);
            businessRepository.save(business);

            BusinessDto businessDto1 = businessConverter.convertBusinessEntityToDto(business);
            return businessDto1;

        } else {

            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("OWNER_NOT_FOUND");
            errorModel.setMessage("Either owner not found or Id does not belongs to owner role!");

            throw new BusinessException(errorModelList);
        }
    }
}
