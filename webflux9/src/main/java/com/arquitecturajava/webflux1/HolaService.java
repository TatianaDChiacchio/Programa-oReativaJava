package com.arquitecturajava.webflux1;

import java.time.Duration;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class HolaService {

	public Mono<String> mensajeHola(String opcion) {
		
		if (opcion.equals("ok")) {
			
			return Mono.just("hola");
		}else {
			
			return Mono.error(new RuntimeException("ha ocurrido un error"));
		}
		
	}
}
