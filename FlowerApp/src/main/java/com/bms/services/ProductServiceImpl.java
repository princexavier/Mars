package com.bms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.entities.Product;
import com.bms.repo.ProductRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo productRepo;
	@Override
	public Product addProduct(String requestData) {
		Product prod  =null;
		try {
			ObjectMapper om = new ObjectMapper();
			prod= om.readValue(requestData, Product.class);
			System.out.println(prod);
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		
		return productRepo.save(prod);
	}

	@Override
	public Optional<Product> getProduct(String productId) {
		// TODO Auto-generated method stub
		Integer pId = Integer.valueOf(productId);
		
		return productRepo.findById(pId);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

}
