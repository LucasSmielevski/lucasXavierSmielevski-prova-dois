package jv.triersistemas.lucasXavierSmielevski_prova_dois.dto;

import java.math.BigDecimal;

import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.MercadoEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoDto {
	private Long id;
	private Long mercadoId;
	private String nome;
	private Integer estoque;
	private BigDecimal valorUnitario;
	
	public ProdutoDto(ProdutoEntity entity) {
		this.id = entity.getId();
		this.mercadoId = entity.getMercado().getId();
		this.nome = entity.getNome();
		this.estoque = entity.getEstoque();
		this.valorUnitario = entity.getValorUnitario();
	}
}
