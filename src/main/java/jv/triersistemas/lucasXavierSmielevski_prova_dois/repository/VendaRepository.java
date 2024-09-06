package jv.triersistemas.lucasXavierSmielevski_prova_dois.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.VendaEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.enums.StatusEnum;

public interface VendaRepository extends JpaRepository<VendaEntity, Long>{
	List<VendaRepository> findByStatus(StatusEnum status);
}
