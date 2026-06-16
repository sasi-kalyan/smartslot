package com.business.smartslot.controller;

import com.business.smartslot.dto.AppUserDto;
import com.business.smartslot.exception.BusinessException;
import com.business.smartslot.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class AppUserController {

    @Autowired
    public AppUserService appUserService;

    @Value("${application.generic.text}")
    public String genericText;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello SmartSlotApp!";
    }

    @PostMapping("/register/{username}")
    public ResponseEntity<AppUserDto> registerAppUser(@PathVariable("username") String username, @RequestBody AppUserDto appUserDto) throws BusinessException {
        AppUserDto appUserDto1 = appUserService.registerAppUser(username, appUserDto);
        ResponseEntity<AppUserDto> responseEntity = new ResponseEntity<>(appUserDto1, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/fetch-all-users")
    public ResponseEntity<List<AppUserDto>> getAllUserResponses(){
        System.out.println(genericText);
        List<AppUserDto> allUsers = appUserService.getAppUsers();
       ResponseEntity<List<AppUserDto>> responseEntity = new ResponseEntity<>(allUsers, HttpStatus.OK);
       return responseEntity;
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<AppUserDto> updateUserResponse(@PathVariable("id") Long id, @RequestBody AppUserDto appUserDto) throws BusinessException {
        AppUserDto appUserDto1 = appUserService.updateAppUser(id, appUserDto);
        ResponseEntity<AppUserDto> responseEntity = new ResponseEntity<>(appUserDto1, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/update-username/{username}")
    public ResponseEntity<AppUserDto> updateUserName(@PathVariable("username") String userName, @RequestBody AppUserDto appUserDto) throws BusinessException {
        AppUserDto appUserDto1 = appUserService.updateUserName(userName, appUserDto);
        ResponseEntity<AppUserDto> responseEntity = new ResponseEntity<>(appUserDto1, HttpStatus.OK);
        return responseEntity;
    }
}
