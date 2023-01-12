package com.arquiteturajava.webflux1;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class NoticiaREST {

	
	
	@RequestMapping(path="webapi/noticiasAgregadas",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
public Flux<List<Noticia>> mensajeNoticias() {
		
		// api de webclient para sse
		
		WebClient cliente= WebClient.create("http://localhost:8080/webapi/noticias");
		ParameterizedTypeReference<ServerSentEvent<Noticia>> tipo=new ParameterizedTypeReference<ServerSentEvent<Noticia>>() {} ; 
		WebClient cliente2= WebClient.create("http://localhost:8080/webapi/noticias2");
		
	
		//obtengo los server send events
		// de ambas fuentes
		// uno lo transformo de forma fuerte
		// el otro simplemente lo convierto en noticas normales
		// y los fusiono con un merge
		Flux<ServerSentEvent<Noticia>> eventos= cliente.get().retrieve().bodyToFlux(tipo);
		Flux<ServerSentEvent<Noticia>> eventos2= cliente2.get().retrieve().bodyToFlux(tipo);	
		Flux<Noticia> nuevoFlux=eventos.map(e->e.data()).map(e->new Noticia(e.getTexto().toUpperCase(),e.getLectores()));
		Flux<Noticia> nuevoFlux2=eventos2.map(e->e.data());
		
		
		return nuevoFlux.mergeWith(nuevoFlux2).buffer(2); 
	}
	
	

	
	
}
