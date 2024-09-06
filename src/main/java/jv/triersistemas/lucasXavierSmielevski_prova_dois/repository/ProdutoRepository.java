package jv.triersistemas.lucasXavierSmielevski_prova_dois.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long>{
	
}
