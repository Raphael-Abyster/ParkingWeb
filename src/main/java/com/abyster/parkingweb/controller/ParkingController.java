package com.abyster.parkingweb.controller;

import com.abyster.parkingweb.controller.api.ParkingApi;
import com.abyster.parkingweb.dto.TicketDto;
import com.abyster.parkingweb.repository.ParkingRepository;
import com.abyster.parkingweb.service.IParkingService;
import com.abyster.parkingweb.dto.ParkingDto;
import com.abyster.parkingweb.service.impl.ParkingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/Parking")
public class ParkingController implements ParkingApi {

    Logger logger = Logger.getLogger(ParkingController.class.getName());
    @Autowired
    private IParkingService service;

    @Override
    public ResponseEntity<ParkingDto> createParking(@RequestBody ParkingDto dto)  {
        logger.info(dto.toString());
        try {
            dto = service.createParking(dto);
        } catch (Exception e) {
            return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public List<ParkingDto> findAllParkings()
    {
        return service.findAll();
    }

    @Override
    public ParkingDto findById(Integer id) {
        return service.findById(id);
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("Running", HttpStatus.OK);
    }

}
