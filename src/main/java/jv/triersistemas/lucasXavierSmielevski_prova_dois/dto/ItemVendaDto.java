package jv.triersistemas.lucasXavierSmielevski_prova_dois.dto;

import java.math.BigDecimal;

import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.ItemVendaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemVendaDto {
	private Long id;
	private Long vendaId;
	private Long produtoId;
	private Integer quantidade;
	private BigDecimal valorTotal;
	
	public ItemVendaDto(ItemVendaEntity entity) {
		this.id = entity.getId();
		this.vendaId = entity.getVenda().getId();
		this.produtoId = entity.getProduto().getId();
		this.quantidade = entity.getQuantidade();
		this.valorTotal = entity.getValorTotal();
	}
}
