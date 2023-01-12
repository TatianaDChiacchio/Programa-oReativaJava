package com.arquiteturajava.webflux1;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WebFluxService {
	
	@Autowired
	WebFluxRepository repositorio;
	
	public Flux<String> mensagem() {
		
		Flux<String> flux= Flux.concat(repositorio.mensagem(),repositorio.mensagem());
		
		return flux;
	}

}
