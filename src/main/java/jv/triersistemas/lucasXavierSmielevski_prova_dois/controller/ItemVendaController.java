package jv.triersistemas.lucasXavierSmielevski_prova_dois.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.ItemVendaDto;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.service.ItemVendaService;

@RestController
@RequestMapping("/itensVenda")
public class ItemVendaController {

	@Autowired
	ItemVendaService service;
	
	@PostMapping
	public ItemVendaDto adicionarItemVenda(@RequestBody ItemVendaDto itemVenda) {
		return service.adicionarItemVenda(itemVenda);
	}
}
