package jv.triersistemas.lucasXavierSmielevski_prova_dois.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.VendaDto;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "venda")
public class VendaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "mercado_id", nullable = false)
	@JsonIgnore
	private MercadoEntity mercado;
	@Enumerated(EnumType.ORDINAL)
	private StatusEnum status;
	@Column(nullable = false)
	private BigDecimal valorTotal;
	@Column(nullable = false)
	private LocalDate dataCriacao;
	
	@OneToMany(mappedBy = "venda", cascade = CascadeType.DETACH)
	private List<ItemVendaEntity> itens;
	
	public VendaEntity(VendaDto dto) {
		this.id = dto.getId();
		this.status = Objects.requireNonNullElse(dto.getStatus(), StatusEnum.EM_ABERTO);
		this.valorTotal = Objects.requireNonNullElse(dto.getValorTotal(), BigDecimal.ZERO);
		this.dataCriacao = Objects.requireNonNullElse(dto.getDataCriacao(), LocalDate.now());
		this.itens = dto.getItens();
	}
	
	public VendaEntity finalizarVenda(StatusEnum status) {
		this.status = status;
		return this;
	}
}
