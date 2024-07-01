package gestion.ticket.TPGestion.modele;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name="APPRENANT")
@Entity
@NoArgsConstructor
@Data
public class Apprenant extends Utilisateur {
    public Apprenant (String username, String motDePasse) {
        super(username, motDePasse, RoleType.APPRENANT);
    }


}

