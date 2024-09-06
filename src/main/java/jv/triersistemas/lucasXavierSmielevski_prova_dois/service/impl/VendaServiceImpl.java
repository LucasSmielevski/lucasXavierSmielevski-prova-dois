package jv.triersistemas.lucasXavierSmielevski_prova_dois.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.VendaDto;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.ItemVendaEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.MercadoEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.VendaEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.enums.StatusEnum;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.repository.MercadoRepository;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.repository.VendaRepository;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.service.VendaService;

@Service
public class VendaServiceImpl implements VendaService{

	@Autowired
	VendaRepository repository;
	
	@Autowired
	MercadoRepository mercadoRepository;
	
	@Override
	public VendaDto adicionarVenda(VendaDto novaVenda) {
		MercadoEntity mercado = mercadoRepository.findById(novaVenda.getMercadoId())
				.orElseThrow(() -> new IllegalArgumentException("Mercado não encontrado"));
		
		VendaEntity venda = new VendaEntity(novaVenda);
		venda.setMercado(mercado);
		
		return new VendaDto(repository.save(venda));
	}

	@Override
	public VendaDto finalizarVenda(Long id, StatusEnum status) {
		Optional<VendaEntity> venda = repository.findById(id);
		if(venda.isPresent()) {
			venda.get().finalizarVenda(status);
			var entidadePersistida = repository.save(venda.get());
			VendaDto vendaDto = new VendaDto(entidadePersistida);
			fecharVenda(vendaDto);
			return vendaDto;
		}
		return null;
	}
	
	public void fecharVenda(VendaDto venda) {
		MercadoEntity mercado = mercadoRepository.findById(venda.getMercadoId())
				.orElseThrow(() -> new IllegalArgumentException("Mercado não encontrado"));
		BigDecimal valorTotal = BigDecimal.ZERO;

		for (ItemVendaEntity itensVenda  : venda.getItens()) {
			valorTotal.add(itensVenda.getValorTotal()) ;
		}
		VendaEntity vendaEntity = new VendaEntity(venda);
		vendaEntity.setValorTotal(valorTotal);
		vendaEntity.setMercado(mercado);
		repository.save(vendaEntity);
	}
	
}
