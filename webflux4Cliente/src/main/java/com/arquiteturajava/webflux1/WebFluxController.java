package com.arquiteturajava.webflux1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;
import reactor.core.publisher.Mono;

@RestController
public class WebFluxController {
	
	
	@Autowired
	WebFluxService servicio;
	
		
	@RequestMapping("/facturas")
	public Flux<Factura> mensajeFacturas() {
		
		return servicio.mensajeFacturas();
	}
	

	
	

}
