package com.abyster.parkingweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ParkingwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingwebApplication.class, args);
	}

}
