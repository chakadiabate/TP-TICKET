package gestion.ticket.TPGestion.service;

import gestion.ticket.TPGestion.modele.Admin;
import gestion.ticket.TPGestion.modele.Apprenant;
import gestion.ticket.TPGestion.modele.Formateur;
import gestion.ticket.TPGestion.modele.Utilisateur;

import java.util.List;


public interface UtilisateurService {



    String ajouterFormateur(Formateur formateur);
    String ajouterApprenant(Apprenant apprenant);

    String modifierAdmin(Long id, Admin adminDetails);

    List<Utilisateur> lireUtilisateurs();

    String supprimerUtilisateur(Long id);


}