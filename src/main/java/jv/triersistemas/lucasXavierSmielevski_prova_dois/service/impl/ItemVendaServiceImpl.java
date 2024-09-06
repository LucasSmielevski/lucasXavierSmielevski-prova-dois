package jv.triersistemas.lucasXavierSmielevski_prova_dois.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.ItemVendaDto;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.ProdutoDto;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.ItemVendaEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.MercadoEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.ProdutoEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.VendaEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.repository.ItemVendaRepository;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.repository.ProdutoRepository;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.repository.VendaRepository;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.service.ItemVendaService;

@Service
public class ItemVendaServiceImpl implements ItemVendaService{

	@Autowired
	private ItemVendaRepository repository;
	
	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public ItemVendaDto adicionarItemVenda(ItemVendaDto novoItem) {
		VendaEntity venda = vendaRepository.findById(novoItem.getVendaId())
				.orElseThrow(() -> new IllegalArgumentException("Venda não encontrado"));
		
		ProdutoEntity produto = produtoRepository.findById(novoItem.getProdutoId())
				.orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
		
		verificarEstoque(novoItem);
		verificarQuantidadeMaiorQueZero(novoItem);
		
		ItemVendaEntity itemVenda = new ItemVendaEntity(novoItem);
		itemVenda.setProduto(produto);
		itemVenda.setVenda(venda);
		
		descontarEstoqueItem(novoItem);
		
		return new ItemVendaDto(repository.save(itemVenda));
	}
	
	public void verificarQuantidadeMaiorQueZero(ItemVendaDto itemVenda) {
		if(itemVenda.getQuantidade() <=0) {
			throw new IllegalArgumentException("A quantidade do item tem que ser maior do que 0");
		}
	}
	
	public String descontarEstoqueItem(ItemVendaDto itemVenda) {
		ProdutoEntity produto = produtoRepository.findById(itemVenda.getProdutoId())
				.orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
		
		if(itemVenda.getProdutoId().equals(produto.getId())) {
			Integer novoValorEstoque = produto.getEstoque() - itemVenda.getQuantidade();
			produto.setEstoque(novoValorEstoque);;
			produtoRepository.save(produto); //Salvando produto com valor de estoque alterado
		}
		return "Novo valor de estoque é: " + produto.getEstoque();
	}
	
	public void verificarEstoque(ItemVendaDto itemVenda) {
		ProdutoEntity produto = produtoRepository.findById(itemVenda.getProdutoId())
				.orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
		
		if(itemVenda.getQuantidade() > produto.getEstoque()) {
			throw new IllegalArgumentException("Não há estoque suficiente deste produto");
		}
	}

}
