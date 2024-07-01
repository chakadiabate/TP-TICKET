package gestion.ticket.TPGestion.service;

import gestion.ticket.TPGestion.modele.BaseConnaissance;

import java.util.List;

public interface BaseConnaissanceService {

    BaseConnaissance ajouterBaseConnaissance(BaseConnaissance baseConnaissance);
    String supprimerBaseConnaissance(Long id);
    List<BaseConnaissance> lireBaseConnaissance();


}
