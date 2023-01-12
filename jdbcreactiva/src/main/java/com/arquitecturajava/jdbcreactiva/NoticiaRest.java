package com.arquitecturajava.jdbcreactiva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class NoticiaRest {
	@Autowired
	NoticiaService servicio;
	
	@GetMapping("/noticias")
	public Flux<Noticia> lista() {
		Flux<Noticia> noticiasA= servicio.buscarTodos();
		Flux<Noticia> noticiasB= servicio.buscarTodos();
		return noticiasA.mergeWith(noticiasB);
		//return noticiasA;
	}
	@PostMapping("/noticias")
	public Mono<Noticia> insertar(@RequestBody Noticia noticia) {
		return servicio.insertar(noticia);
	}

	
		
}
