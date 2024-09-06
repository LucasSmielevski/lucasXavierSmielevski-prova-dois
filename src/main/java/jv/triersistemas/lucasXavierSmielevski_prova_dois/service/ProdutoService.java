package jv.triersistemas.lucasXavierSmielevski_prova_dois.service;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.ProdutoDto;

public interface ProdutoService {
	ProdutoDto adicionarProduto(ProdutoDto novoProduto);
	
	Page<ProdutoDto> listarProdutos(Pageable page , String nome);
	
	ProdutoDto alterarEstoqueProduto(Long id, Integer estoque);
	
	ProdutoDto alterarValorProduto(Long id, BigDecimal novoValor);
}
