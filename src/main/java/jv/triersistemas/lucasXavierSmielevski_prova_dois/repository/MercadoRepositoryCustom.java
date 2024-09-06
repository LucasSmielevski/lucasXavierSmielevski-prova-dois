package jv.triersistemas.lucasXavierSmielevski_prova_dois.repository;

import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.MercadoDto;

public interface MercadoRepositoryCustom {
	MercadoDto buscarProdutoComMaisVendaNoMercado(Long mercadoId);
}
