package com.portfolio.helpdesk.controller;

import com.portfolio.helpdesk.entity.Ticket;
import com.portfolio.helpdesk.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://helpdesk-frontend-sooty.vercel.app")
@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // --- LECTURE ---
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    // --- CRÉATION ---
    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    // --- MISE À JOUR (Statut uniquement) ---
    @PutMapping("/{id}/status")
    public ResponseEntity<Ticket> updateTicketStatus(@PathVariable Long id, @RequestBody StatusUpdateRequest request) {
        Ticket updated = ticketService.updateStatus(id, request.getStatus());
        return ResponseEntity.ok(updated);
    }

    // --- SUPPRESSION ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build(); // Renvoie un code 204 (Plus pro qu'un simple void)
    }

    /**
     * DTO Interne pour la mise à jour du statut.
     * En entreprise, on évite d'envoyer des Strings "nues" car c'est dur à documenter et à valider.
     */
    public static class StatusUpdateRequest {
        private String status;

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
    }
}