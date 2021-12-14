package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.demo.dao.ProductDao;
import com.example.demo.dao.ProductDaoImpl;

@Configuration
@EnableWebMvc
public class WebMvcConfig {
	
	
	@Autowired
	Environment environment;

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver v = new InternalResourceViewResolver();
		v.setPrefix("/");

		return v;
	}
	
	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new  DriverManagerDataSource();
		ds.setUrl(environment.getProperty("spring.datasource.url"));
		ds.setUsername(environment.getProperty("spring.datasource.username"));
		ds.setPassword(environment.getProperty("spring.datasource.password"));
		
		return ds;
	}
	
	@Bean
	public ProductDao getProductDao() {
		return new ProductDaoImpl(getDataSource());
	}

}
