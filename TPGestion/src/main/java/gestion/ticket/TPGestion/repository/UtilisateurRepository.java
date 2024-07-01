package gestion.ticket.TPGestion.repository;

import gestion.ticket.TPGestion.modele.RoleType;
import gestion.ticket.TPGestion.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Optional<Utilisateur> findByUsername(String username);
    List<Utilisateur> findByRole(RoleType role);
}