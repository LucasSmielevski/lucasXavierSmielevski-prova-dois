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
import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.ItemVendaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "itemVenda")
public class ItemVendaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "venda_id", nullable = false)
	@JsonIgnore
	private VendaEntity venda;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "produto_id", nullable = false)
	@JsonIgnore
	private ProdutoEntity produto;
	@Column(nullable = false)
	private Integer quantidade;
	@Column(nullable = false)
	private BigDecimal valorTotal;
	
	
	public ItemVendaEntity(ItemVendaDto dto) {
		this.id = dto.getId();
		this.quantidade = dto.getQuantidade();
		this.valorTotal = dto.getValorTotal();
	}
}
