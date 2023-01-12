package com.arquitecturajava.reactor;

import java.time.Duration;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Principal {

	public static void main(String[] args) {
		
		
		Mono<String> mimono= Mono.just("hola").delayElement(Duration.ofSeconds(2));
		//mimono.subscribe(System.out::println);
		
		Mono<String> mimono2= Mono.just("hola2").delayElement(Duration.ofSeconds(3));
		//mimono2.subscribe(System.out::println);
		
		Flux<String> combinar=Flux.merge(mimono,mimono2);
		//estamos combinando dos monos para construir un flux
		combinar.subscribe(System.out::println);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
