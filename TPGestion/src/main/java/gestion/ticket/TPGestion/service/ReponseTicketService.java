package gestion.ticket.TPGestion.service;

import gestion.ticket.TPGestion.modele.ReponseTicket;
import gestion.ticket.TPGestion.modele.Ticket;
import gestion.ticket.TPGestion.modele.Utilisateur;

import java.util.List;

public interface ReponseTicketService {
    ReponseTicket creerreponseticket(ReponseTicket reponseticket);
    String supprimerreponseticket(Long id);
    List<ReponseTicket> lire();
    List<Ticket> lireTicketsParUtilisateur(Utilisateur utilisateur) ;

    }


