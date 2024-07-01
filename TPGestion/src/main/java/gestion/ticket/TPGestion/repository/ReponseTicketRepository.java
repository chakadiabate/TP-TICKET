package gestion.ticket.TPGestion.repository;

import gestion.ticket.TPGestion.modele.ReponseTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReponseTicketRepository extends JpaRepository<ReponseTicket , Long> {
}
