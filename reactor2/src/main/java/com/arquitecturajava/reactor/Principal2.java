package com.arquitecturajava.reactor;


import java.util.function.Function;

import reactor.core.publisher.Flux;

public class Principal2 {

	public static void main(String[] args) {
		
		Flux<Integer> flux1 = Flux.just(2,3,4,5,6,1,7);
		Flux<Integer> flux2 = Flux.just(3,3,3,4,5,8,9);
		
		//flux1.filter(e -> e>=5).map(e -> e + 1).subscribe(System.out::println);
		//flux2.filter(e -> e>=5).map(e -> e + 1).subscribe(System.out::println);
		
		Function<Flux<Integer>, Flux<Integer>> transformation = flux -> flux.filter(e -> e>=5).map(e -> e + 1);
		flux1.transform(transformation).subscribe(System.out::println);
		flux2.transform(transformation).subscribe(System.out::println);

	}

}
