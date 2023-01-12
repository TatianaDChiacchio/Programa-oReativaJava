package com.arquiteturajava.webflux1;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class NoticiaREST {

	@Autowired
	NoticiaService servicio;
	
	@RequestMapping("webapi/noticia")
	public Mono<Noticia> mensajeNoticia() {
		return servicio.noticia();
		
	}
	
	
	//server send events 
	//vamos a emitir un evento de servidor cada dos segundos
	// por lo tanto necesitaremos un cliente que acceda ello
	@RequestMapping(path="webapi/noticias",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Noticia> mensajeNoticias() {
		return servicio.noticias().delayElements(Duration.ofSeconds(2));
		
	}
	@RequestMapping(path="webapi/noticias2",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Noticia> mensajeNoticias2() {
		return servicio.noticias2().delayElements(Duration.ofSeconds(2));
		
	}
	
	
	

	
	
}
