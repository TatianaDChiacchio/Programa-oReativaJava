package com.arquitecturajava.jdbcreactiva;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

// y este interface a nivel de Spring Data será capaz
// de implemementar una clase con todas las operaciones básicas

@Repository
public interface NoticiaRepository extends ReactiveCrudRepository<Noticia,Integer> {

	@Query("select * from Noticias where texto in (select sleep(2))")
	public Flux<Noticia> buscarTodos();
	
}
