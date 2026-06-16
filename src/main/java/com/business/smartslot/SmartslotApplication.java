package com.business.smartslot;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class SmartslotApplication {

	//http://localhost:8080/api/v1/user/hello
	public static void main(String[] args) {
		SpringApplication.run(SmartslotApplication.class, args);
	}



}
