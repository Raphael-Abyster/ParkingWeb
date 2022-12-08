package com.abyster.parkingweb.repository;

import com.abyster.parkingweb.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
