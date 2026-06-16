package com.business.smartslot.service;

import com.business.smartslot.dto.AppUserDTO;
import com.business.smartslot.exception.BusinessException;

import java.util.List;

public interface AppUserService {

    AppUserDTO registerAppUser(String username, AppUserDTO userResponseDto) throws BusinessException;

    List<AppUserDTO> getAppUsers();

    AppUserDTO updateAppUser(Long id, AppUserDTO appUserDTO) throws BusinessException;

    AppUserDTO updateUserName(String userName, AppUserDTO appUserDTO) throws BusinessException;
}
