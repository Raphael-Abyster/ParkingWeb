package com.abyster.parkingweb;

import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/Parking")
public class ParkingController {

    Logger logger = Logger.getLogger(ParkingController.class.getName());
    @Autowired
    private IParkingService service;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ParkingDto> createParking(@RequestBody ParkingDto dto)  {
        logger.info(dto.toString());
        try {
            dto = service.createParking(dto);
        } catch (Exception e) {
            return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("Running", HttpStatus.OK);
    }

}
