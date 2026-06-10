package com.business.smartslot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserRequestController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello SmartSlotApp!";
    }
}
