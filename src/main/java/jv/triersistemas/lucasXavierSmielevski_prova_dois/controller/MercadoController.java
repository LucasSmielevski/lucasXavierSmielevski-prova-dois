package jv.triersistemas.lucasXavierSmielevski_prova_dois.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.lucasXavierSmielevski_prova_dois.dto.MercadoDto;
import jv.triersistemas.lucasXavierSmielevski_prova_dois.service.MercadoService;

@RestController
@RequestMapping("/mercados")
public class MercadoController {
	
	@Autowired
	MercadoService service;
	
	//1
	@PostMapping
	public MercadoDto adicionarMercado(@RequestBody MercadoDto novoMercado) {
		return service.adicionarReserva(novoMercado);
	}
}
