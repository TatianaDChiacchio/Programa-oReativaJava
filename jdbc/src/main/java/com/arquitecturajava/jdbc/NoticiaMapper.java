package com.arquitecturajava.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class NoticiaMapper implements RowMapper<Noticia> {

	@Override
	public Noticia mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new Noticia (rs.getString("texto"),rs.getInt("lectores"));
	}

}
