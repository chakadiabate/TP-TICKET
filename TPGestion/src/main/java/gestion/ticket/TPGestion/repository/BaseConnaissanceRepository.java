package gestion.ticket.TPGestion.repository;

import gestion.ticket.TPGestion.modele.BaseConnaissance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseConnaissanceRepository extends JpaRepository<BaseConnaissance, Long> {
}
