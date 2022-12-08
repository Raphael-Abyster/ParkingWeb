package com.abyster.parkingweb.service.impl;

import com.abyster.parkingweb.dto.ParkingDto;
import com.abyster.parkingweb.dto.TicketDto;
import com.abyster.parkingweb.repository.TicketRepository;
import com.abyster.parkingweb.service.ITicketService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements ITicketService {

    private TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
    Logger logger = Logger.getLogger(TicketServiceImpl.class.getName());

    @Override
    public TicketDto createTicket(TicketDto dto) {
        logger.info(dto.toString());
        dto.setUuid(UUID.randomUUID().toString());
        dto.setImmatriculation(dto.getImmatriculation());
        dto.setDateDebut(dto.getDateDebut());
        dto.setDateFin(dto.getDateFin());
        dto.setVisRes(dto.isVisRes());

        return TicketDto.fromEntity(ticketRepository.save(TicketDto.toEntity(dto)));
    }

    @Override
    public List<TicketDto> findAll() {
        return ticketRepository.findAll().stream()
                .map(TicketDto::fromEntity)
                .collect(Collectors.toList());
    }

}
