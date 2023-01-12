package com.arquitecturajava.reactor;

import reactor.core.publisher.Flux;

public class Principal3 {

	public static void main(String[] args) {
		
		Flux<Integer> flux = Flux.create(e ->{
			
			for(int i=0; i<=10; i++) {
				e.next(i);
			}
			e.complete();
		});

		flux.subscribe(System.out::println);
		
		Flux flux2 = Flux.range(0, 21);
		
		flux2.subscribe(System.out::println);
	}
	
	

}
