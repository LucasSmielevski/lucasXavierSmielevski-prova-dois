package jv.triersistemas.lucasXavierSmielevski_prova_dois.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.MercadoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "mercado")
public class MercadoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String nomeFantasia;
	@Column(nullable = false, unique = true)
	private String cnpj;
	
	@OneToMany(mappedBy = "mercado", cascade = CascadeType.DETACH)
	private List<ProdutoEntity> produtos;
	
	public MercadoEntity(MercadoDto dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.nomeFantasia = dto.getNomeFantasia();
		this.cnpj = dto.getCnpj();
		this.produtos = dto.getProdutos();
	}
}
