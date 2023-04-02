package com.tutorial.demoapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SpringbootTutotialApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringbootTutotialApplication.class, args);
	}



}
