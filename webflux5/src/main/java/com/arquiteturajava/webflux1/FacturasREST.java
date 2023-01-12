package com.arquiteturajava.webflux1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;
import reactor.core.publisher.Mono;

@RestController
public class FacturasREST {
	
	
	@Autowired
	FacturasService servicio;
	
	@RequestMapping("/facturas")
	public Flux<Factura> mensajeFacturas() {
		
		Flux<Factura> flux1 = servicio.facturas1();
		
		//concatWith executa o primeiro bloco e quando termina executa o bloco 2
		// de tal forma que os dados vem ordenados a nível assíncrono
		return flux1.concatWith(servicio.facturas2());
	}
	

	

}
