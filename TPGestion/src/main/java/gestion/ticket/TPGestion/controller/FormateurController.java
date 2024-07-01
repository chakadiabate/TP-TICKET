package gestion.ticket.TPGestion.controller;

import gestion.ticket.TPGestion.modele.*;
import gestion.ticket.TPGestion.repository.TicketRepository;
import gestion.ticket.TPGestion.repository.UtilisateurRepository;
import gestion.ticket.TPGestion.service.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@Setter
@RestController
@AllArgsConstructor
@RequestMapping("/formateur")
public class FormateurController {


    private final TicketRepository ticketRepository;
    private final UtilisateurService utilisateurService;
    private final TicketService ticketService;
    private final BaseConnaissanceService baseConnaissanceService;
    private final ReponseTicketService reponseTicketService;
    private final UtilisateurRepository utilisateurRepository;
    @GetMapping("/readlistticket")
    public List<Ticket> readlistticket() {
        return ticketService.lireticket();
    }

    @PostMapping("/creereponseticket")
    public ReponseTicket creerreponseticket(@RequestBody ReponseTicket reponseTicket, @RequestParam Long ticketId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Utilisateur utilisateur = utilisateurRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé: " + username));

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new IllegalArgumentException("Ticket non trouvé avec l'ID : " + ticketId));

        reponseTicket.setFormateur(utilisateur);
        reponseTicket.setTicket(ticket);


        ticket.setStatut(StatutTicket.RESOLU);
        ticketService.updateTicket(ticket);

        return reponseTicketService.creerreponseticket(reponseTicket);
    }


    @GetMapping("/readreponseticket")
    public List<ReponseTicket> readreponseticket() {
        return reponseTicketService.lire();
    }

    @DeleteMapping("/deletereponseticket/{id}")
    public String deletereponseticket(@PathVariable Long id) {
        return reponseTicketService.supprimerreponseticket(id);
    }

    @GetMapping("/readbaseconnaissance")
    public List<BaseConnaissance> readbaseconnaissance() {
        return baseConnaissanceService.lireBaseConnaissance();
    }

    @PostMapping("/createbaseconnaissance")
    public BaseConnaissance createbaseconnaissance(@RequestBody BaseConnaissance baseConnaissance) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();


        Utilisateur utilisateur = utilisateurRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé: " + username));


        baseConnaissance.setUtilisateur(utilisateur);

        return baseConnaissanceService.ajouterBaseConnaissance(baseConnaissance);

    }

    @DeleteMapping("/deletebaseConnaissance/{id}")
    public String deletebaseConnaissance(@PathVariable Long id) {
        return baseConnaissanceService.supprimerBaseConnaissance(id);
    }

    @GetMapping("/lirePourFormateur")
    public List<Ticket> lireTicketsPourFormateur() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Utilisateur utilisateur = utilisateurRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé: " + username));

        if (!utilisateur.getRole().equals(RoleType.FORMATEUR)) {
            throw new IllegalArgumentException("Accès refusé : Il n'est pas formateur");
        }

        List<Ticket> tickets = ticketService.lireticket();

        for (Ticket ticket : tickets) {
            if (ticket.getStatut() == StatutTicket.EN_COURS) {
                ticket.setStatut(StatutTicket.OUVERT);
                ticketService.updateTicket(ticket);

            }
        }

        return tickets;
    }




}
