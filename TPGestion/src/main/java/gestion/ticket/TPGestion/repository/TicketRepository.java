package gestion.ticket.TPGestion.repository;

import gestion.ticket.TPGestion.modele.Ticket;
import gestion.ticket.TPGestion.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByUtilisateur(Utilisateur utilisateur);
}