package jv.triersistemas.lucasXavierSmielevski_prova_dois.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.MercadoDto;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.entity.MercadoEntity;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.repository.MercadoRepository;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.service.MercadoService;

@Service
public class MercadoServiceImpl implements MercadoService{

	@Autowired
	private MercadoRepository repository;
	
	@Override
	public MercadoDto adicionarReserva(MercadoDto novoMercado) {
		String cnpjExtraido = limparCnpj(novoMercado.getCnpj());
		MercadoEntity mercado = new MercadoEntity(novoMercado);
		mercado.setCnpj(cnpjExtraido);
		
		return new MercadoDto(repository.save(mercado));
	}
	
	
	public String limparCnpj(String cnpj) {
		return cnpj.replaceAll("[^\\d]", "");
	}

}
