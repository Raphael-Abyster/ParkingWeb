package com.abyster.parkingweb.controller;

import com.abyster.parkingweb.dto.ParkingDto;
import com.abyster.parkingweb.dto.TicketDto;
import com.abyster.parkingweb.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/Ticket")
public class TicketController {

    Logger logger = Logger.getLogger(TicketController.class.getName());
    @Autowired
    private ITicketService service;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto dto)  {
        logger.info(dto.toString());
        try {
            dto = service.createTicket(dto);
        } catch (Exception e) {
            return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<TicketDto> findAllTickets()
    {
        return service.findAll();
    }

    @GetMapping("/")
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("Running", HttpStatus.OK);
    }

}
