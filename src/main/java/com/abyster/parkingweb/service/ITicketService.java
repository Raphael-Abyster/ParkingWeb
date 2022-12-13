package com.abyster.parkingweb.service;

import com.abyster.parkingweb.dto.TicketDto;

import java.util.List;

public interface ITicketService {

    public TicketDto createTicket(TicketDto dto) throws Exception;

    List<TicketDto> findAll();

    TicketDto findById(Integer id);

    void delete(Integer id);

}
