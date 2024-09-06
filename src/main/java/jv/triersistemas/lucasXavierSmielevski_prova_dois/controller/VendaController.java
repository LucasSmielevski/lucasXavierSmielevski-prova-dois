package jv.triersistemas.lucasXavierSmielevski_prova_dois.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.ProdutoDto;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.VendaDto;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.enums.StatusEnum;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {
	
	@Autowired
	VendaService vendaService;
	
	//8
	@PostMapping
	public VendaDto adicionarVenda(@RequestBody VendaDto novaVenda) {
		return vendaService.adicionarVenda(novaVenda);
	}
	
	@PutMapping("/finalizar")
	public VendaDto finalizarVenda(@RequestParam Long id, @RequestParam StatusEnum status) {
		return vendaService.finalizarVenda(id, status);
	}
}
