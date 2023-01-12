package com.arquiteturajava.webflux1;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@Service
public class WebFluxService {
	
	
	
	public Flux<Factura> mensajeFacturas() {

		WebClient cliente = WebClient.create("http://localhost:8080/facturas");
		return cliente.get().retrieve().bodyToFlux(Factura.class);
	}

}
