package jv.triersistemas.lucasXavierSmielevski_prova_dois.service;

import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.VendaDto;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.enums.StatusEnum;

public interface VendaService {
	VendaDto adicionarVenda(VendaDto novaVenda);
	
	VendaDto finalizarVenda(Long id, StatusEnum status);
}
