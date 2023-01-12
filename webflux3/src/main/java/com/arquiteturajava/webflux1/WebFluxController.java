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
	
	@RequestMapping("/webflux")
	public Flux<String> mensajeHola() {
		
		return servicio.mensagem();
	}
	
	@RequestMapping("/facturas")
	public Flux<Factura> mensajeFacturas() {
		
		return servicio.mensajeFacturas();
	}
	

	@RequestMapping("/facturasMap")
	public Flux<String> mensajeFacturas2() {
		
		//return servicio.mensajeFacturas().map(e -> e.getConcepto());
		
		return servicio.mensajeFacturas().log().map(e->e.getConcepto()).log().map(String::toUpperCase);
	}
	
	@RequestMapping("/facturasFilter")
	public Flux<Factura> mensajeFacturas3() {
		
		return servicio.mensajeFacturas().log().filter(f->f.getImporte()>200).log();
	}
	
	
	@RequestMapping("/facturasReduce")
	public Mono<Integer> mensajeFacturas4() {
		
		
		//return servicio.mensajeFacturas().map(e->e.getImporte());
		return servicio.mensajeFacturas().map(e->e.getImporte()).reduce((a,b)->a+b);
	}
	
	
	@RequestMapping("/facturasFlatMap")
	public Flux<Factura> mensajeFacturas5() {
		
		Flux<Factura> lista1= servicio.mensajeFacturas();
		Flux<Factura> lista2= servicio.mensajeFacturas();
		// tengo dos listas y por lo tanto
		// el flux es un flux no de facturas sino de listas de facturas
		//[    e1,e2    e3,e4  ]
		Flux<Flux<Factura>> lista3= Flux.just(lista1,lista2);
		return lista3.flatMap(e->e);
	}
	
	
	@RequestMapping("/facturasAgrupadas")
	public Flux<Factura> mensajeFacturas6() {
		//hashmap de Java
		Flux<GroupedFlux<String,Factura>> flux=servicio.mensajeFacturas().groupBy(Factura::getConcepto);
		return flux.filter(d->d.key().equals("ordenador")).flatMap(e->e);
	
	}
	

}
