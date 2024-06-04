package com.example.communitysportsfacility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommunitysportsfacilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunitysportsfacilityApplication.class, args);
		System.out.println("Connected to the database!");
	}

}
