package com.cognizant.signupservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SignupServiceApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SignupServiceApplication.class);

	public static void main(String[] args) { 
		LOGGER.info("Start");
		SpringApplication.run(SignupServiceApplication.class, args);
		LOGGER.info("End"); 
	}

}