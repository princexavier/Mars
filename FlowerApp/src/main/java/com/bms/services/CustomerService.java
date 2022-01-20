package com.bms.services;

import java.util.List;
import java.util.Optional;

import com.bms.entities.Customer;


public interface CustomerService {

	public Customer addCustomer(String customerData);
	public Optional<Customer> getCustomer(String customerId);
	public List<Customer> getAllCustomers();
 

}
