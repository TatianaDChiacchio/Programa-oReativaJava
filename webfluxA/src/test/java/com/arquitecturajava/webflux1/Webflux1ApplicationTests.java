package com.arquitecturajava.webflux1;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.scheduler.VirtualTimeScheduler;

@SpringBootTest
class Webflux1ApplicationTests {

	@Test
	void testBasico() {

		Flux<String> textos = Flux.just("hola", "que", "tal", "estas");
		StepVerifier.create(textos)
		.expectNext("hola")
		.expectNext("que")
		.expectNext("tal")
		.expectNext("estas")
		.expectComplete()
		.verify();

		
	}

	@Test
	void testTemporal() {
		VirtualTimeScheduler agenda= VirtualTimeScheduler.getOrSet();
		
		Flux<String> textos = Flux.just("hola", "que", "tal", "estas").delayElements(Duration.ofSeconds(1),agenda);

		StepVerifier.withVirtualTime(()->textos)
		.expectSubscription()
		.thenAwait(Duration.ofSeconds(1))
		.expectNext("hola")
		.thenAwait(Duration.ofSeconds(1))
		.expectNext("que")
		.thenAwait(Duration.ofSeconds(1))
		.expectNext("tal")
		.thenAwait(Duration.ofSeconds(1))
		.expectNext("estas")
		.verifyComplete();
		

	}
	
	
	@Test
	void testBackPressure() {

		Flux<Long> textos = Flux.interval(Duration.ofMillis(500)).take(100);
		
		textos.subscribe(System.out::println);
		
	}
	
}
