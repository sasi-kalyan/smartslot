package com.business.smartslot.controller;

import com.business.smartslot.dto.AppUserDTO;
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
    public ResponseEntity<AppUserDTO> registerAppUser(@PathVariable("username") String username, @RequestBody AppUserDTO appUserDTO) throws BusinessException {
        AppUserDTO appUserDTO1 = appUserService.registerAppUser(username, appUserDTO);
        ResponseEntity<AppUserDTO> responseEntity = new ResponseEntity<>(appUserDTO1, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/fetch-all-users")
    public ResponseEntity<List<AppUserDTO>> getAllUserResponses(){
        System.out.println(genericText);
        List<AppUserDTO> allUsers = appUserService.getAppUsers();
       ResponseEntity<List<AppUserDTO>> responseEntity = new ResponseEntity<>(allUsers, HttpStatus.OK);
       return responseEntity;
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<AppUserDTO> updateUserResponse(@PathVariable("id") Long id, @RequestBody AppUserDTO appUserDTO) throws BusinessException {
        AppUserDTO appUserDTO1 = appUserService.updateAppUser(id, appUserDTO);
        ResponseEntity<AppUserDTO> responseEntity = new ResponseEntity<>(appUserDTO1, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/update-username/{username}")
    public ResponseEntity<AppUserDTO> updateUserName(@PathVariable("username") String userName, @RequestBody AppUserDTO appUserDTO) throws BusinessException {
        AppUserDTO appUserDTO1 = appUserService.updateUserName(userName, appUserDTO);
        ResponseEntity<AppUserDTO> responseEntity = new ResponseEntity<>(appUserDTO1, HttpStatus.OK);
        return responseEntity;
    }
}
