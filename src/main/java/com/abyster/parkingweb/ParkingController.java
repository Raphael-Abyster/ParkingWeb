package com.abyster.parkingweb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Logger;

@Controller("/Parking")
public class ParkingController {

    Logger logger = Logger.getLogger(ParkingController.class.getName());
    @Autowired
    private IParkingService service;

    @PostMapping("/")
    public ResponseEntity<ParkingDto> createParking(ParkingDto dto){
        logger.info(dto.toString());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
