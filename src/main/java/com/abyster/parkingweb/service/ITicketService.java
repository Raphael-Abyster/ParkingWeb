package com.abyster.parkingweb.service;

import com.abyster.parkingweb.dto.TicketDto;

public interface ITicketService {

    public TicketDto createTicket(TicketDto dto) throws Exception;

}
