package com.portfolio.helpdesk.service;

import com.portfolio.helpdesk.entity.Ticket;
import com.portfolio.helpdesk.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


    public Ticket createTicket(Ticket ticket) {
        ticket.setStatus("OUVERT");

        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    public Ticket updateStatus(Long id, String newStatus) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket introuvable"));
        ticket.setStatus(newStatus);
        return ticketRepository.save(ticket);
    }
}