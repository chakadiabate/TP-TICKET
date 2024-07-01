package gestion.ticket.TPGestion.service;

import gestion.ticket.TPGestion.modele.Ticket;
import gestion.ticket.TPGestion.modele.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    String creerticket(Ticket ticket);
    String supprimerticket(Long id);
    List<Ticket> lireticket();

    Optional<Ticket> findById(Long id);
    Ticket updateTicket(Ticket ticket);
    List<Ticket> lireTicketsParUtilisateur(Utilisateur utilisateur) ;
}
