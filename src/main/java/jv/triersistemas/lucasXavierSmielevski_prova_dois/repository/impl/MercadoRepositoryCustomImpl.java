package jv.triersistemas.lucasXavierSmielevski_prova_dois.repository.impl;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.MercadoDto;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.ProdutoDto;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.QItemVendaEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.QMercadoEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.QProdutoEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.QVendaEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.repository.MercadoRepositoryCustom;

@Repository
public class MercadoRepositoryCustomImpl implements MercadoRepositoryCustom{
	
	@PersistenceContext
	private EntityManager em;
	
	
	final QProdutoEntity produto = QProdutoEntity.produtoEntity;
	final QMercadoEntity mercado = QMercadoEntity.mercadoEntity;
	final QVendaEntity venda = QVendaEntity.vendaEntity;
	final QItemVendaEntity itemVenda = QItemVendaEntity.itemVendaEntity;

	@Override
	public MercadoDto buscarProdutoComMaisVendaNoMercado(Long mercadoId) {
		JPAQuery<MercadoDto> query = new JPAQuery<>(em);
		query.select(produto).from(mercado).join(mercado.produtos, produto)
		.join(itemVenda.produto, produto).where(mercado.id.eq(mercadoId)); // nao consegui terminar
		return null;
	}

}
