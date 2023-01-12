package com.arquitecturajava.webflux1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class HolaRest {

	@Autowired
	HolaService servicio;
	
	@RequestMapping("/hola")
	public Mono<ResponseEntity<String>> mensajeHola(String opcion) {
		
		return servicio.mensajeHola(opcion).map(m->new ResponseEntity<String>(m,HttpStatus.OK))
				.onErrorResume(e->Mono.just(new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR)));
	}
}
