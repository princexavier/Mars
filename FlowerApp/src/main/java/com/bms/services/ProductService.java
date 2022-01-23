package com.bms.services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.bms.entities.Product;

public interface ProductService {

	public Product addProduct(String requestData);

	public Optional<Product> getProduct(String productId);
	
	public List<Product> getAllProducts();

	public HashMap<String, Object> deleteProduct(String productId);

}
