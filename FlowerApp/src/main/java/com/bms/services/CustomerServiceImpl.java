package com.bms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.entities.Customer;
import com.bms.repo.CustomerRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo customerRepo;

	@Override
	public Customer addCustomer(String customerData) {
		Customer customer = null;
		try {
			ObjectMapper om = new ObjectMapper();
			customer = om.readValue(customerData, Customer.class);
			System.out.println(customer);

		} catch (Exception e) {
			e.printStackTrace();

		}

		// TODO Auto-generated method stub
		return customerRepo.save(customer);
	}

	@Override
	public Optional<Customer> getCustomer(String customerId) {
		Integer custId = Integer.parseInt(customerId);
		return customerRepo.findById(custId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

}
