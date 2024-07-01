package gestion.ticket.TPGestion.service;

import gestion.ticket.TPGestion.modele.ReponseTicket;
import gestion.ticket.TPGestion.modele.Ticket;
import gestion.ticket.TPGestion.modele.Utilisateur;
import gestion.ticket.TPGestion.repository.ReponseTicketRepository;
import gestion.ticket.TPGestion.repository.TicketRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Getter
@Setter
@Service
public class ReponseTicketServiceimpl implements ReponseTicketService{

    private final TicketRepository ticketRepository;
    private final ReponseTicketRepository reponseTicketRepository;
    /**
     * @param reponseticket
     * @return
     */
    @Override
    public ReponseTicket creerreponseticket(ReponseTicket reponseticket) {
        return reponseTicketRepository.save(reponseticket);
    }

    @Override
    public String supprimerreponseticket(Long id) {
        reponseTicketRepository.deleteById((long) id);
        return "Reponse supprimée";
    }

    @Override
    public List<ReponseTicket> lire() {
        return reponseTicketRepository.findAll();
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
