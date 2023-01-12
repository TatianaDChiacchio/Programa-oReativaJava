package com.arquitecturajava.jdbcreactiva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NoticiaService {

	@Autowired
	private NoticiaRepository repositorio;

	public NoticiaService() {

	}

	public Flux<Noticia> buscarTodos() {

		return repositorio.buscarTodos();
	}
	@Transactional
	public Mono<Noticia> insertar(Noticia noticia){
		
		return repositorio.save(noticia);
	}

}
