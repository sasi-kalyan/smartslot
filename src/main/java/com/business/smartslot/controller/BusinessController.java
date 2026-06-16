package com.business.smartslot.controller;

import com.business.smartslot.dto.BusinessDto;
import com.business.smartslot.exception.BusinessException;
import com.business.smartslot.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/business")
public class BusinessController {

    @Autowired
    public BusinessService businessService;

    @PostMapping("/register-business")
    public ResponseEntity<BusinessDto> registerBusiness(@RequestBody BusinessDto businessDto) throws BusinessException {

        BusinessDto businessDto1 = businessService.registerBusiness(businessDto);
        ResponseEntity<BusinessDto> responseEntity = new ResponseEntity<>(businessDto1, HttpStatus.CREATED);

        return responseEntity;
    }
}
