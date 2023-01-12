package com.arquitecturajava.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticiaService {

	@Autowired
	private NoticiaRepository repositorio;
	
	public List<Noticia> buscarTodos() {
		
		// cada uno tarda 4 segundos (4)
		List<Noticia> lista=repositorio.buscarTodos();
		//(4)
		List<Noticia> lista2=repositorio.buscarTodos();
		lista.addAll(lista2);
		return lista;
	}
}
