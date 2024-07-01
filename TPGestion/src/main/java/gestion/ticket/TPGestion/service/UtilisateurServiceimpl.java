package gestion.ticket.TPGestion.service;

import gestion.ticket.TPGestion.modele.*;
import gestion.ticket.TPGestion.repository.UtilisateurRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
@AllArgsConstructor

public class UtilisateurServiceimpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    /**
     * @param formateur
     * @return
     */
    @Override
    public String ajouterFormateur(Formateur formateur) {
        formateur.setRole(RoleType.FORMATEUR);
        formateur.setMotDePasse(passwordEncoder.encode(formateur.getMotDePasse()));
        //formateur.setMotDePasse("{noop}" + formateur.getMotDePasse());
         utilisateurRepository.save(formateur);
        return "Nouveau formateur ajouter avec succes";
    }

    /**
     * @param apprenant
     * @return
     */
    @Transactional
    @Override
    public String ajouterApprenant(Apprenant apprenant) {

        apprenant.setRole(RoleType.APPRENANT);
        apprenant.setMotDePasse(passwordEncoder.encode(apprenant.getMotDePasse()));

        utilisateurRepository.save(apprenant);
        return "Nouveau apprenant ajouter!";
    }

    /**
     * @param adminDetails
     * @return
     */
    @Override
    public String modifierAdmin(Long id, Admin adminDetails) {
        Admin admin = (Admin) utilisateurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé avec id : " + id));

        admin.setUsername(adminDetails.getUsername());
        admin.setMotDePasse(passwordEncoder.encode(adminDetails.getMotDePasse()));
        admin.setRole(RoleType.ADMIN);

         utilisateurRepository.save(admin);
        return "Admin modifier avec succes!";
    }

    /**
     * @return
     */
    @Transactional
    @Override
    public List<Utilisateur> lireUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Transactional
    @Override
    public String supprimerUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
        return "utilisateur supprimer";
    }

    /**
     * @return
     */


    @PostConstruct
    public void initAdmin() {
        List<Utilisateur> admins = utilisateurRepository.findByRole(RoleType.ADMIN);
        if (admins.isEmpty()) {
            Admin admin = new Admin("admin", passwordEncoder.encode("admin"));
            utilisateurRepository.save(admin);
        }
    }
}
