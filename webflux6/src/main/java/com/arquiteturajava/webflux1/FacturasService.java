package com.arquiteturajava.webflux1;

import java.time.Duration;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class FacturasService {
	
	
	public Flux<Factura> facturas1() {

		Factura f1 = new Factura("1", "ordenador", 400);
		Factura f2 = new Factura("2", "movil", 500);
		f1.addLinea(new LineaFactura(1,"cpu",200));
		f1.addLinea(new LineaFactura(2,"monitor",200));
		
		f2.addLinea(new LineaFactura(1,"terminal",400));
		f2.addLinea(new LineaFactura(2,"auriculares",100));
		
				

		Flux<Factura> flux = Flux.just(f1, f2).delayElements(Duration.ofSeconds(1));
		return flux;
	}
	
	public Flux<Factura> facturas2() {

		
		
		Factura f1 = new Factura("3", "televisor", 100);
		Factura f2 = new Factura("4", "dron", 200);
		f1.addLinea(new LineaFactura(1,"televisor",200));
		f1.addLinea(new LineaFactura(2,"barra",200));
		
		f2.addLinea(new LineaFactura(1,"dron",400));
		f2.addLinea(new LineaFactura(2,"mando",100));
		
				

		Flux<Factura> flux = Flux.just(f1, f2).delayElements(Duration.ofSeconds(1));
		return flux;
	}
}
