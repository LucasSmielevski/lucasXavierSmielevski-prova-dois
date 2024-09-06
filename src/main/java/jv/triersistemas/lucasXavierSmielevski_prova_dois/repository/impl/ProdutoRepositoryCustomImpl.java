package jv.triersistemas.lucasXavierSmielevski_prova_dois.repository.impl;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.ProdutoDto;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.QMercadoEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.QProdutoEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.repository.ProdutoRepositoryCustom;

@Repository
public class ProdutoRepositoryCustomImpl implements ProdutoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	final QProdutoEntity produto = QProdutoEntity.produtoEntity;
	final QMercadoEntity mercado = QMercadoEntity.mercadoEntity;
	
	@Override
	public Page<ProdutoDto> buscaPaginadaProdutoPorNome(Pageable pageable, String nome) {
		BooleanBuilder condicoes = new BooleanBuilder();
		
		if(Objects.nonNull(nome) && !nome.isEmpty()) {
			condicoes.and(produto.nome.containsIgnoreCase(nome));
		}
		
		JPAQuery<ProdutoDto> query = new JPAQuery<>(em);
		query.select(Projections.constructor(ProdutoDto.class, produto))
		.from(mercado)
		.join(mercado.produtos,produto)
		.where(condicoes)
		.orderBy(produto.nome.asc(), produto.id.asc());

		query.limit(pageable.getPageSize());
		query.offset(pageable.getOffset());
		
		return new PageImpl<ProdutoDto>(query.fetch(), pageable, query.fetchCount());
		
	}

}
