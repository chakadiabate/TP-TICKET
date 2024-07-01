package gestion.ticket.TPGestion.service;

import gestion.ticket.TPGestion.modele.StatutTicket;
import gestion.ticket.TPGestion.modele.Ticket;
import gestion.ticket.TPGestion.modele.Utilisateur;
import gestion.ticket.TPGestion.repository.TicketRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Setter
@Getter
@AllArgsConstructor
public class TicketServiceimpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Override
    public String creerticket(Ticket ticket) {
        ticket.setStatut(StatutTicket.EN_COURS);
         ticketRepository.save(ticket);
        return "Le ticket a été créer";
    }

    @Override
    public String supprimerticket(Long id) {
        ticketRepository.deleteById((long) id);
        return "Ticket supprimer";
    }

    @Override
    public List<Ticket> lireticket() {
        return ticketRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Ticket> findById(Long id) {
        return ticketRepository.findById(id);
    }

    /**
     * @param ticket
     * @return
     */
    @Override
    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    /**
     * @param utilisateur
     * @return
     */
    @Override
    public List<Ticket> lireTicketsParUtilisateur(Utilisateur utilisateur) {
        return ticketRepository.findByUtilisateur(utilisateur);
    }

}