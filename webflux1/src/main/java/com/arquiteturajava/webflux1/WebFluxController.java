package com.arquiteturajava.webflux1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class WebFluxController {
	
	@Autowired
	WebFluxService service;
	
	@RequestMapping("/webflux")
	public Mono<String> mensagem() {
		
		return service.mensagem();
	}

}
