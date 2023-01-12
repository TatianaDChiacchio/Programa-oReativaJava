package com.arquiteturajava.webflux1;

import java.time.Duration;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NoticiaService {
	
	
	public Mono<Noticia> noticia() {
		return Mono.just(new Noticia("noticia1", 100));
	}

	public Flux<Noticia> noticias() {

		Noticia n1 = new Noticia("noticia1", 100);
		Noticia n2 = new Noticia("noticia2", 100);
		Noticia n3 = new Noticia("noticia3", 100);
		Noticia n4 = new Noticia("noticia4", 100);
		Noticia n5 = new Noticia("noticia5", 100);
		Noticia n6 = new Noticia("final", 100);
		

		return Flux.just(n1, n2, n3, n4, n5,n6);
	}
	
	public Flux<Noticia> noticias2() {

		Noticia n1 = new Noticia("noticia6", 100);
		Noticia n2 = new Noticia("noticia7", 100);
		Noticia n3 = new Noticia("noticia8", 100);
		Noticia n4 = new Noticia("noticia9", 100);
		Noticia n5 = new Noticia("noticia10", 100);
		Noticia n6 = new Noticia("final", 100);
		

		return Flux.just(n1, n2, n3, n4, n5,n6);
	}
	
}
