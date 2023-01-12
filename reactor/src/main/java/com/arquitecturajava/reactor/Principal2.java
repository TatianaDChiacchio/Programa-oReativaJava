package com.arquitecturajava.reactor;

import reactor.core.publisher.Flux;

public class Principal2 {

	public static void main(String[] args) {
		
		//construir un flux 
		// que es un observable para listas de elementos 
		
		Flux<String> elementos=Flux.just("hola","que","tal","estas");
		elementos.subscribe(System.out::println);

	}

}
