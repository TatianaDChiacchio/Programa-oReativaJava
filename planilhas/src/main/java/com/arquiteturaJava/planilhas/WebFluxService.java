package com.arquiteturaJava.planilhas;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.arquiteturaJava.webFlux1.Factura;

import reactor.core.publisher.Flux;

@Service
public class WebFluxService {
	
	
	
	public Flux<Factura> mensajeFacturas() {

		WebClient cliente= WebClient.create("http://localhost:8080/facturas");
		
		return cliente.get().retrieve().bodyToFlux(Factura.class); 
	}

}
