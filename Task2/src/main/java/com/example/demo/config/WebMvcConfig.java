package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.demo.dao.ProductDao;
import com.example.demo.dao.ProductDaoImpl;

@Configuration
@EnableWebMvc
public class WebMvcConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver v = new InternalResourceViewResolver();
		v.setPrefix("/");

		return v;
	}
	
	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new  DriverManagerDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/demo");
		ds.setUsername("root");
		ds.setPassword("root@123");
		
		return ds;
	}
	
	@Bean
	public ProductDao getProductDao() {
		return new ProductDaoImpl(getDataSource());
	}

}
