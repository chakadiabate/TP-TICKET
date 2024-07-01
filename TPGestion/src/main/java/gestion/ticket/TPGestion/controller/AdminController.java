package gestion.ticket.TPGestion.controller;

import gestion.ticket.TPGestion.modele.Apprenant;
import gestion.ticket.TPGestion.modele.Formateur;
import gestion.ticket.TPGestion.modele.Utilisateur;
import gestion.ticket.TPGestion.modele.Admin;
import gestion.ticket.TPGestion.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UtilisateurService utilisateurService;


    @PostMapping("/creerformateur")
    public String creerFormateur(@RequestBody Formateur formateur) {
        return utilisateurService.ajouterFormateur(formateur);
    }

    @PostMapping("/creerapprenant")
    public String creerApprenant(@RequestBody Apprenant apprenant) {
        return utilisateurService.ajouterApprenant(apprenant);
    }

    @PutMapping("/modifieradmin/{id}")
    public String modifierAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        return utilisateurService.modifierAdmin(id, admin);
    }

    @GetMapping("/listutilisateurs")
    public List<Utilisateur> lireUtilisateurs() {
        return utilisateurService.lireUtilisateurs();
    }

    @DeleteMapping("/supprimerutilisateur/{id}")
    public String supprimerUtilisateur(@PathVariable Long id) {
        return utilisateurService.supprimerUtilisateur(id);
    }
}
