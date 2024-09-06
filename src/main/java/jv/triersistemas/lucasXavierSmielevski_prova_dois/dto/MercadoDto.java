package jv.triersistemas.lucasXavierSmielevski_prova_dois.dto;

import java.util.List;

import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.MercadoEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MercadoDto {
	private Long id;
	private String nome;
	private String nomeFantasia;
	private String cnpj;
	private List<ProdutoEntity> produtos;


	public MercadoDto(MercadoEntity entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.nomeFantasia = entity.getNomeFantasia();
		this.cnpj = entity.getCnpj();
		this.produtos = entity.getProdutos();
	}
}
