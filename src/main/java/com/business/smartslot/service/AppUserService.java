package com.business.smartslot.service;

import com.business.smartslot.dto.AppUserDto;
import com.business.smartslot.exception.BusinessException;

import java.util.List;

public interface AppUserService {

    AppUserDto registerAppUser(String username, AppUserDto userResponseDto) throws BusinessException;

    List<AppUserDto> getAppUsers();

    AppUserDto updateAppUser(Long id, AppUserDto appUserDTO) throws BusinessException;

    AppUserDto updateUserName(String userName, AppUserDto appUserDTO) throws BusinessException;
}
