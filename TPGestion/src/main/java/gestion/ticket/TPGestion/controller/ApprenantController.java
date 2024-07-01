package gestion.ticket.TPGestion.controller;

import gestion.ticket.TPGestion.modele.*;
import gestion.ticket.TPGestion.repository.TicketRepository;
import gestion.ticket.TPGestion.repository.UtilisateurRepository;
import gestion.ticket.TPGestion.service.*;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/apprenant")
public class ApprenantController {

    private final BaseConnaissanceService baseConnaissanceService;
    private final ReponseTicketService reponseTicketService;
    private final TicketService ticketService;
    private final UtilisateurService utilisateurService;
    private final TicketRepository ticketRepository;
    private final UtilisateurRepository utilisateurRepository;

    @PostMapping("/creerticket")
    public String createticket(@RequestBody Ticket ticket) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Recherche de l'utilisateur par nom d'utilisateur
        Utilisateur utilisateur = utilisateurRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé: " + username));



        // Assigner l'utilisateur connecté au ticket
        ticket.setUtilisateur(utilisateur);
        String nouveauTicket = ticketService.creerticket(ticket);

        return nouveauTicket;

    }

    @DeleteMapping("/deleteticket/{id}")
    public String deleteticket(@PathVariable Long id) {
        return ticketService.supprimerticket(id);
    }

    @GetMapping("/readlistticket")
    public List<Ticket> readlistticket() {
        return ticketService.lireticket();
    }


    @GetMapping("/lirePourFormateur")
    public List<Ticket> lireTicketsPourFormateur() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Utilisateur utilisateur = utilisateurRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Non trouvé: " + username));

        List<Ticket> tickets = ticketService.lireticket();

        for (Ticket ticket : tickets) {
            if (ticket.getStatut() == StatutTicket.EN_COURS) {
                ticket.setStatut(StatutTicket.OUVERT);
                ticketService.creerticket(ticket);

            }
        }

        return tickets;
    }


    @GetMapping("/readreponseticket")
    public List<ReponseTicket> readreponseticket() {
        return reponseTicketService.lire();
    }

    @GetMapping("/readbaseconnaissance")
    public List<BaseConnaissance> readbaseconnaissance() {
        return baseConnaissanceService.lireBaseConnaissance();
    }
}

