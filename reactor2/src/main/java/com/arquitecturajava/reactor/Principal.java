package com.arquitecturajava.reactor;

import java.time.Duration;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Principal {

	public static void main(String[] args) {
		
		
		Flux<String> flux1 = Flux.interval(Duration.ofMillis(100)).map(e -> e+"A").take(500);
		
		Flux<String> flux2 = Flux.interval(Duration.ofMillis(100)).map(e -> e+"B").take(500);
		
		//Flux<String> fluxFinal = flux1.mergeWith(flux2).sample(Duration.ofSeconds(1));
		Flux<List<String>> fluxFinal = flux1.mergeWith(flux2).buffer(Duration.ofSeconds(1));
		
		fluxFinal.subscribe(System.out::println);
		
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
