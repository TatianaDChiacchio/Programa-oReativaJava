package com.arquiteturajava.webflux1;

import java.time.Duration;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class FacturasService {
	
	
	public Flux<Factura> facturas1() {

		Factura f1 = new Factura("1", "ordenador ", 200);
		Factura f2 = new Factura("2", "movil ", 500);
		Factura f3 = new Factura("3", "tablet ", 250);
		Factura f4 = new Factura("4", "auriculares ", 100);
		
		
		

		Flux<Factura> flux = Flux.just(f1, f2, f3, f4).delayElements(Duration.ofSeconds(1));
		return flux;
	}
	
	public Flux<Factura> facturas2() {

				
		Factura f5 = new Factura("5", "ordenador", 200);
		Factura f6 = new Factura("6", "movil", 500);
		Factura f7 = new Factura("7", "tablet", 250);
		Factura f8 = new Factura("8", "auriculares", 100);
		

		Flux<Factura> flux = Flux.just(f5, f6, f7, f8).delayElements(Duration.ofSeconds(1));
		return flux;
	}

}
