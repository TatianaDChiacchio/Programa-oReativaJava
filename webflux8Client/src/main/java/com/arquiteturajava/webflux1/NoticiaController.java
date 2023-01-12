package com.arquiteturajava.webflux1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticiaController {

	@RequestMapping("/index")
	public String index() {
		return "index";
		
	}
	
}
