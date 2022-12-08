package com.abyster.parkingweb.service.impl;

import com.abyster.parkingweb.dto.TicketDto;
import com.abyster.parkingweb.service.ITicketService;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.logging.Logger;

@Service
public class TicketServiceImpl implements ITicketService {

    Logger logger = Logger.getLogger(TicketServiceImpl.class.getName());

    @Override
    public TicketDto createTicket(TicketDto dto) {
        logger.info(dto.toString());
        dto.setUuid(UUID.randomUUID().toString());

        return dto;
    }

}
