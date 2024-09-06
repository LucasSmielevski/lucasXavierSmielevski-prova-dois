package jv.triersistemas.lucasXavierSmielevski_prova_dois.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.ItemVendaDto;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.ProdutoDto;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.VendaDto;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.ItemVendaEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.MercadoEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.ProdutoEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.VendaEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.enums.StatusEnum;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.repository.ItemVendaRepository;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.repository.MercadoRepository;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.repository.ProdutoRepository;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.repository.ProdutoRepositoryCustom;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.repository.VendaRepository;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private MercadoRepository mercadoRepository;
	
	@Autowired
	private ProdutoRepositoryCustom produtoRepositoryCustom;

	@Override
	public ProdutoDto adicionarProduto(ProdutoDto novoProduto) {
		MercadoEntity mercado = mercadoRepository.findById(novoProduto.getMercadoId())
				.orElseThrow(() -> new IllegalArgumentException("Mercado não encontrado"));

		ProdutoEntity produto = new ProdutoEntity(novoProduto);
		produto.setMercado(mercado);

		return new ProdutoDto(repository.save(produto));
	}
	

	@Override
	public Page<ProdutoDto> listarProdutos(Pageable page, String nome) {
		return produtoRepositoryCustom.buscaPaginadaProdutoPorNome(page, nome);
	}

	@Override
	public ProdutoDto alterarEstoqueProduto(Long id, Integer estoque) {
		Optional<ProdutoEntity> produto = repository.findById(id);
		if (produto.isPresent()) {
			produto.get().atualizarEstoque(estoque);
			var entidadePersistida = repository.save(produto.get());
			return new ProdutoDto(entidadePersistida);
		}
		return null;
	}

	@Override
	public ProdutoDto alterarValorProduto(Long id, BigDecimal novoValor) {
		Optional<ProdutoEntity> produto = repository.findById(id);
		if (produto.isPresent()) {
			produto.get().atualizarValorUnitario(novoValor);
			var entidadePersistida = repository.save(produto.get());
			return new ProdutoDto(entidadePersistida);
		}
		return null;
	}
}
