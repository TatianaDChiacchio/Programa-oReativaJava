package com.arquiteturaJava.planilhas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arquiteturaJava.webFlux1.Factura;

import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;
import reactor.core.publisher.Mono;

@RestController
public class WebFluxController {
	
	
	@Autowired
	WebFluxService servicio;
	
		
	@RequestMapping("/webApi/facturas")
	public Flux<Factura> mensajeFacturas() {
		
		return servicio.mensajeFacturas();
	}
	

	
	

}
