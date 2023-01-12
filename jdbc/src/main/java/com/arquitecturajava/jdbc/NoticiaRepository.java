package com.arquitecturajava.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NoticiaRepository {

	
	// pues esta plantilla simplifica el código de JDBC que tenemos
	// que escribir reduciendolo al minimo necesario
	@Autowired
	private JdbcTemplate plantilla;
	
	public List<Noticia> buscarTodos() {
		
		return plantilla.query("select * from Noticias where texto in (select sleep(2))",new NoticiaMapper());
	}
}
