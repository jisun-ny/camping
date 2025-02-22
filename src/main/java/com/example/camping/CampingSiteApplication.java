package com.example.camping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CampingSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampingSiteApplication.class, args);
	}
}
