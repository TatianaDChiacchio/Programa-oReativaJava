package com.arquitecturajava.webflux1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import org.springframework.web.reactive.function.server.RouterFunctions;
@Configuration
public class RouterConfiguracion {

	@Bean
	public RouterFunction<ServerResponse> rutas(HolaService servicio) {
		
		return 
				RouterFunctions.route(GET("/hola"),req->ServerResponse.ok()
				.body(servicio.mensajeHola(),String.class))
				.andRoute(GET("/adios"),req->ServerResponse.ok()
				.body(servicio.mensajeAdios(),String.class));
	}
	
	
}
