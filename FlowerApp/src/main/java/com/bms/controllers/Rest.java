package com.bms.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.entities.Bms;
import com.bms.entities.Customer;
import com.bms.entities.Product;
import com.bms.services.BmsService;
import com.bms.services.CustomerService;
import com.bms.services.ProductService;

@RestController("/")
public class Rest {

	@Autowired
	CustomerService custService;

	@Autowired
	ProductService productService;

	@Autowired
	BmsService bmsService;

	@PostMapping("addCustomer")
	public Customer addCustomer(@RequestBody String requestData) {

		return custService.addCustomer(requestData);

	}

	@GetMapping("getCustomer/{id}")
	public Optional<Customer> getCustomer(@PathVariable("id") String customerId) {

		return custService.getCustomer(customerId);

	}

	@GetMapping("getAllCustomers")
	public List<Customer> getAllCustomers() {

		return custService.getAllCustomers();

	}

	@GetMapping("getAllProducts")
	public List<Product> getAllProducts() {

		return productService.getAllProducts();

	}

	@PostMapping("addProduct")
	public Product addProduct(@RequestBody String requestData) {

		return productService.addProduct(requestData);

	}

	@GetMapping("getProduct/{id}")
	public Optional<Product> getProduct(@PathVariable("id") String productId) {

		return productService.getProduct(productId);

	}

	@PostMapping("saveBmsList")
	public List<Bms> addBmsList(@RequestBody String requestData) {

		return bmsService.addBmsList(requestData);

	}

	@GetMapping("getBmsList")
	public List<Bms> getBmsList() {

		return bmsService.getBmsList();

	}
	
	@GetMapping("getDetails")
	public List<Bms> getDetails() {

		return bmsService.getDetails();

	}

	@RequestMapping("welcome")
	public String welcome() {

		return "WElomce";

	}

}
