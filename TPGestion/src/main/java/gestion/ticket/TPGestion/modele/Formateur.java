package gestion.ticket.TPGestion.modele;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="FORMATEUR")
@Entity
@NoArgsConstructor
@Data
public class Formateur extends Utilisateur {
    public Formateur(String username, String motDePasse) {
        super(username, motDePasse, RoleType.FORMATEUR);
    }
}
