package gestion.ticket.TPGestion.service;

import gestion.ticket.TPGestion.modele.BaseConnaissance;
import gestion.ticket.TPGestion.repository.BaseConnaissanceRepository;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
@AllArgsConstructor
public class BaseConnaissanceServiceimpl implements BaseConnaissanceService{

    private final BaseConnaissanceRepository baseConnaissanceRepository;

    @Override
    public BaseConnaissance ajouterBaseConnaissance(BaseConnaissance baseConnaissance) {
        return baseConnaissanceRepository.save(baseConnaissance);
    }

    @Override
    public String supprimerBaseConnaissance(Long id) {
         baseConnaissanceRepository.deleteById(id);
         return "BASE DE CONNAISSANCE SUPPRIME";
    }

    @Override
    public List<BaseConnaissance> lireBaseConnaissance() {
        return baseConnaissanceRepository.findAll();
    }
}
