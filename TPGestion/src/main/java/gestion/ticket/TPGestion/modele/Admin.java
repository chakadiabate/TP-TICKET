package gestion.ticket.TPGestion.modele;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@Table(name="ADMIN")
@Entity

public class Admin extends Utilisateur {


    public Admin() {}

    public Admin(String username, String motDePasse) {
        super(username, motDePasse, RoleType.ADMIN);

    }


}
