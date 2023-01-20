package com.abyster.parkingweb.controller;

import com.abyster.parkingweb.controller.api.TicketApi;
import com.abyster.parkingweb.dto.TicketDto;
import com.abyster.parkingweb.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/ticket")
public class TicketController implements TicketApi {

    Logger logger = Logger.getLogger(TicketController.class.getName());
    @Autowired
    private ITicketService service;

    @Override
    @PostMapping("/create")
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto dto)  {
        logger.info(dto.toString());
        try {
            dto = service.createTicket(dto);
        } catch (Exception e) {
            return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "/all")
    public List<TicketDto> findAllTickets()
    {
        return service.findAll();
    }

    @Override
    @GetMapping(value = "/{uuid}")
    public TicketDto findById(@PathVariable("uuid") Integer uuid) {
        return service.findById(uuid);
    }

    @GetMapping(value = "/")
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("Running", HttpStatus.OK);
    }

    //Non fonctionnel, mais pas demandé
    @Override
    @RequestMapping(value = "/delete/{uuid}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("uuid") Integer uuid) {
        service.delete(uuid);
    }

}
