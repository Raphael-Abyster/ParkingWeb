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
    @PostMapping("/create")
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
    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public List<ParkingDto> findAllParkings()
    {
        return service.findAll();
    }

    @Override
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ParkingDto findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("Running", HttpStatus.OK);
    }

    //Non fonctionnel, mais pas demandé
    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
