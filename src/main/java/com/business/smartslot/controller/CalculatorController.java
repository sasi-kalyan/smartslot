package com.business.smartslot.controller;

import com.business.smartslot.dto.CalculatorDto;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

    @GetMapping("/add")
    //RequestParam maps the data on backend variables which are coming from the client
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2){
        return num1 + num2;
    }

    @GetMapping("/subtract/{num1}/{num2}")
    //Path variable maps the data from URL to the java variables
    public Double subtract(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2){
        Double result = num1 > num2 ? num1 - num2 : num2 - num1;
        return result;
    }

    @PostMapping("/multiply")
    //RequestBody maps the JSON object coming from the client to respective java variables in DTO
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDto calculatorDto){
        Double result =  calculatorDto.getNum1()*calculatorDto.getNum2()*
                calculatorDto.getNum3()*calculatorDto.getNum4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}
