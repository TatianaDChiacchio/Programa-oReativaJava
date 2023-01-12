package com.arquitecturajava.jdbcreactiva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.connectionfactory.R2dbcTransactionManager;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.w3c.dom.views.AbstractView;

import io.r2dbc.spi.ConnectionFactory;

@SpringBootApplication
@EnableTransactionManagement
@EnableR2dbcRepositories
public class JdbcreactivaApplication  {

	public static void main(String[] args) {
		SpringApplication.run(JdbcreactivaApplication.class, args);
	}

	
}
