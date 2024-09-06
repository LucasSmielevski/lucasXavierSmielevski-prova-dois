package jv.triersistemas.lucasXavierSmielevski_prova_dois.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.ProdutoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "produto")
public class ProdutoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "mercado_id", nullable = false)
	@JsonIgnore
	private MercadoEntity mercado;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private Integer estoque;
	@Column(nullable = false)
	private BigDecimal valorUnitario;
	
	public ProdutoEntity(ProdutoDto dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.estoque = dto.getEstoque();
		this.valorUnitario = dto.getValorUnitario();
	}
	
	public ProdutoEntity atualizarEstoque(Integer estoque) {
		this.estoque = estoque;
		return this;
	}
	
	public ProdutoEntity atualizarValorUnitario(BigDecimal novoValor) {
		this.valorUnitario = novoValor;
		return this;
	}
}
