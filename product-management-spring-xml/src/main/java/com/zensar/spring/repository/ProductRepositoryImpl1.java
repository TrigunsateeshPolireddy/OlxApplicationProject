package com.zensar.spring.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.zensar.spring.beans.Product;

public class ProductRepositoryImpl1 implements ProductRepository {

	private JdbcTemplate template;

	public ProductRepositoryImpl1() {

	}

	public int insertProduct(Product product) {
		//createTable();
		String sql = "insert into product values(" + product.getProductId() + ",'" + product.getProductName() + "',"
				+ product.getProductCost() + ");";
		template.execute(sql);
		return 1;
	}

	public void createTable() {
		template.execute("create table product(productId int ,productName varchar(50),productCost int)");
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<Product> readProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		SqlParameterSource namedParameters = new MapSqlParameterSource("productId", productId);
		String sql = "delete from product where productId=:productId";

		return template.update(sql, namedParameters) > 0;
	}

	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		String sql = "update product set productName = :productName, productCost = :productCost where productId=:productId";

		Map<String, String> params = new HashMap<String, String>();

		params.put("productId", "2");
		params.put("productName", "Computer");
		params.put("productCost", "91283");
		return template.update(sql, params);
	}

}
