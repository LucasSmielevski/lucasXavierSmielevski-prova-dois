package jv.triersistemas.lucasXavierSmielevski_prova_dois.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.ItemVendaEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.VendaEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendaDto {
	private Long id;
	private Long mercadoId;
	private StatusEnum status;
	private BigDecimal valorTotal;
	private LocalDate dataCriacao;
	
	private List<ItemVendaEntity> itens;

	
	public VendaDto(VendaEntity entity) {
		this.id = entity.getId();
		this.mercadoId = entity.getMercado().getId();
		this.status = entity.getStatus();
		this.valorTotal = entity.getValorTotal();
		this.dataCriacao = entity.getDataCriacao();
		this.itens = entity.getItens();
	}
}
