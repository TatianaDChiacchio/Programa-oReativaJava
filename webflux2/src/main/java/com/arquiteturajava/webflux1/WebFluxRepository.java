package com.arquiteturajava.webflux1;

import java.time.Duration;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public class WebFluxRepository {
	
public Mono<String> mensagem() {
		
		return Mono.just("WebFlux").delayElement(Duration.ofSeconds(5));
	}

}
