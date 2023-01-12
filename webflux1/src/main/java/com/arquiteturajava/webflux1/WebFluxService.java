package com.arquiteturajava.webflux1;

import java.time.Duration;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class WebFluxService {
	
	public Mono<String> mensagem(){
		return Mono.just("WebFlux").delayElement(Duration.ofSeconds(5));
	}

}
