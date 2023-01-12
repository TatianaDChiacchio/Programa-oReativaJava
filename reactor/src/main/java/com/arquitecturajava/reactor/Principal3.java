package com.arquitecturajava.reactor;

import reactor.core.publisher.Mono;

public class Principal3 {

	public static void main(String[] args) {
		
		//nuestro primer ejemplo con reactor
		// tenemos un elemento de tipo mono
		// que es como un tipo de observable
		//pero para Spring framework
		Mono<String> mimono= Mono.just("hola");
		mimono.subscribe(System.out::println);
		
		
		
	
	}

}
