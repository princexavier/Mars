package com.bms.controllers;

import java.util.HashMap;
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
import com.bms.services.PlacesService;
import com.bms.services.ProductService;
import com.bms.services.ReportService;

@RestController("/")
public class Rest {

	@Autowired
	CustomerService custService;

	@Autowired
	ProductService productService;

	@Autowired
	BmsService bmsService;
	
	@Autowired
	ReportService reportsService;

	@Autowired
	PlacesService placeService;
	
	@PostMapping("/")
	public String greet() {

		return "Welcome";

	}

	@PostMapping("addCustomer")
	public Customer addCustomer(@RequestBody String requestData) {

		return custService.addCustomer(requestData);

	}

	@GetMapping("getCustomer/{id}")
	public Optional<Customer> getCustomer(@PathVariable("id") String customerId) {

		return custService.getCustomer(customerId);

	}
	
	@PostMapping("deleteCustomer")
	public HashMap<String,Object> deleteCustomer(@RequestBody String requestData) {

		 return custService.deleteCustomer(requestData);

	}

	@GetMapping("getAllCustomers")
	public List<Customer> getAllCustomers() {

		return custService.getAllCustomers();

	}
	
	@PostMapping("deleteProduct")
	public HashMap<String, Object> deleteProduct(@RequestBody String productId) {

		return productService.deleteProduct(productId);

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
	
	@GetMapping("getBmsList")
	public HashMap<String, Object> getBmsList() {

		return bmsService.getBmsList();

	}

	@PostMapping("saveBmsList")
	public List<Bms> addBmsList(@RequestBody String requestData) {

		return bmsService.addBmsList(requestData);

	}

	
	@GetMapping("getDetails")
	public List<Bms> getDetails() {

		return bmsService.getDetails();

	}

	@RequestMapping("getDropValues")
	public HashMap<String, Object> welcome() {
		
		
		return bmsService.getDropValues();

	}
	
	@PostMapping("reports")
	public HashMap<String, Object> welcome(@RequestBody String requestData) {
		
		
		return reportsService.getReports( requestData);

	}

	@PostMapping("savePlace")
	public HashMap<String, Object> savePlace(@RequestBody String requestData) {


		return placeService.savePlace( requestData);

	}
	@GetMapping("getAllPlaces")
	public HashMap<String, Object> getAllPlaces() {


		return placeService.getAllPlaces( );

	}




	
	

}
