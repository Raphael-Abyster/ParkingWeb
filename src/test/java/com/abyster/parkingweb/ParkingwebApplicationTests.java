package com.abyster.parkingweb;

import com.abyster.parkingweb.service.impl.TicketServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

@SpringBootTest
class ParkingwebApplicationTests {

	static Logger log = Logger.getLogger(ParkingwebApplicationTests.class.getName());
	@BeforeAll
	static void setup() {
		log.info("@BeforeAll - executes once before all test methods in this class");
	}

	@BeforeEach
	void init() {
		log.info("@BeforeEach - executes before each test method in this class");
	}

}
