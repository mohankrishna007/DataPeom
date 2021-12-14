package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Product;

public class ProductDaoImpl implements ProductDao{

	private JdbcTemplate jdbcTemplate;
	
	public ProductDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Product> productList() {
		List<Product> list = jdbcTemplate.query("SELECT * FROM demo.products", new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product prod = new Product();
				prod.setId(rs.getInt("id"));
				prod.setName(rs.getString("name"));
				prod.setPrice(rs.getInt("price"));
				prod.setManufacture_date(rs.getDate("manufacture_date").toLocalDate());
				prod.setStocks(rs.getInt("stocks"));
				
				return prod;
				
			}
		});
		// TODO Auto-generated method stub
		return list;
	}

}
