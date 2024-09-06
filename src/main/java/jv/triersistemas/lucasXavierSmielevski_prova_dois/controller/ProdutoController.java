package jv.triersistemas.lucasXavierSmielevski_prova_dois.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.ProdutoDto;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	
	//4
	@PostMapping
	public ProdutoDto adicionarProduto(@RequestBody ProdutoDto novoProduto) {
		return produtoService.adicionarProduto(novoProduto);
	}
	
	@GetMapping
	public Page<ProdutoDto> listarProdutos(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size,
			@RequestParam(required = false) String nome) {
		return produtoService.listarProdutos(Pageable.ofSize(size).withPage(page), nome);
	}
	
	@PutMapping("/estoque")
	public ProdutoDto atualizarEstoqueProduto(@RequestParam Long id, @RequestParam Integer estoque) {
		return produtoService.alterarEstoqueProduto(id, estoque);
	}
	
	@PutMapping("/valor")
	public ProdutoDto atualizarValorUnitarioProduto(@RequestParam Long id, @RequestParam BigDecimal valorUnitario) {
		return produtoService.alterarValorProduto(id, valorUnitario);
	}
	
}
