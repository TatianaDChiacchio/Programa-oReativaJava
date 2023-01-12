package com.arquiteturaJava.planilhas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring6.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;

import com.arquiteturaJava.webFlux1.Factura;

import reactor.core.publisher.Flux;

@Controller
public class FacturasController {
	
	
	

	@Autowired
	WebFluxService miservicio;
	
	@RequestMapping("/facturas")
	public String facturas(final Model modelo) {
		
		Flux<Factura> miflux= miservicio.mensajeFacturas();
		
		IReactiveDataDriverContextVariable variableReactiva=new ReactiveDataDriverContextVariable(miflux);
		
		modelo.addAttribute("facturas",variableReactiva);
		return "facturas";
	}
}
