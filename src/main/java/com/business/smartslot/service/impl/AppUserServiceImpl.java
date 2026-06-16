package com.business.smartslot.service.impl;

import com.business.smartslot.converter.AppUserConverter;
import com.business.smartslot.dto.AppUserDTO;
import com.business.smartslot.entity.AppUser;
import com.business.smartslot.exception.BusinessException;
import com.business.smartslot.exception.ErrorModel;
import com.business.smartslot.repository.AppUserRepository;
import com.business.smartslot.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    public AppUserRepository appUserRepository;

    @Autowired
    public AppUserConverter appUserConverter;

    @Override
    public AppUserDTO registerAppUser(String username, AppUserDTO appUserDTO) throws BusinessException {

        AppUserDTO appUserDTO1 = null;

        Optional<AppUser> optAppUser = appUserRepository.findByUserName(username);
        if(!optAppUser.isPresent()) {
            AppUser appUser = appUserConverter.convertDTOtoEntity(appUserDTO);
            appUserRepository.save(appUser);

            appUserDTO1 = appUserConverter.convertEntitytoDTO(appUser);
        }else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("USER_EXISTS");
            errorModel.setMessage("Username already exists!");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        return appUserDTO1;
    }

    @Override
    public List<AppUserDTO> getAppUsers() {
        List<AppUser> allResponses = (List<AppUser>) appUserRepository.findAll();
        List<AppUserDTO> allResponsesDTO = new ArrayList<>();
        for(AppUser appUser : allResponses){
            AppUserDTO appUserDTO = appUserConverter.convertEntitytoDTO(appUser);
            allResponsesDTO.add(appUserDTO);
        }

        return allResponsesDTO;
    }

    @Override
    public AppUserDTO updateAppUser(Long id, AppUserDTO appUserDTO) throws BusinessException {
        Optional<AppUser> ur = appUserRepository.findById(id);
        AppUserDTO appUserDTO1 = null;

        if(ur.isPresent()){
            AppUser appUser = ur.get();
            appUser.setFullName(appUserDTO.getFullName());
            appUser.setEmail(appUserDTO.getEmail());
            appUser.setPhoneNumber(appUserDTO.getPhoneNumber());

            //after update -- save again
            appUserRepository.save(appUser);

            appUserDTO1 = appUserConverter.convertEntitytoDTO(appUser);
        }else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_USER");
            errorModel.setMessage("Incorrect Username or Password");

            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }

        return appUserDTO1;
    }

    @Override
    public AppUserDTO updateUserName(String userName, AppUserDTO appUserDTO) throws BusinessException {

        AppUserDTO appUserDTO1 = null;
        Optional<AppUser> optAppUser = appUserRepository.findByUserName(userName);

        if(optAppUser.isPresent()) {

            AppUser appUser = optAppUser.get();
            appUser.setUserName(appUserDTO.getUserName());
            appUser.setUpdatedAt(appUserConverter.getFormattedTime());
            appUserRepository.save(appUser);

            appUserDTO1 = appUserConverter.convertEntitytoDTO(appUser);

        }else{

            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_USER");
            errorModel.setMessage("Username not found!");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }

        return appUserDTO1;
    }
}
