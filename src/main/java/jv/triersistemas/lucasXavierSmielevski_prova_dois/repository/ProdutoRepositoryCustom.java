package jv.triersistemas.lucasXavierSmielevski_prova_dois.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.ProdutoDto;

public interface ProdutoRepositoryCustom {
	Page<ProdutoDto> buscaPaginadaProdutoPorNome(Pageable pageable, String nome);

}
