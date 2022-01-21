package com.bms.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.entities.Bms;
import com.bms.entities.Customer;
import com.bms.entities.Product;
import com.bms.repo.BmsRepo;
import com.bms.repo.CustomerRepo;
import com.bms.repo.ProductRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BmsServiceImpl implements BmsService{

	
	@Autowired
	BmsRepo bmsrepo;
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	ProductRepo productRepo;
	
	@Override
	public List<Bms> addBmsList(String requestData) {
		// TODO Auto-generated method stub
		 List<Bms> bmsList = new ArrayList<Bms>();
		try {
			ObjectMapper om = new ObjectMapper();
			bmsList= om.readValue(requestData,new TypeReference<ArrayList<Bms>>() {});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return bmsrepo.saveAll(bmsList);
	}

	@Override
	public HashMap<String,Object> getBmsList() {
		// TODO Auto-generated method stub
		HashMap<String,Object>responseMap=new HashMap<String, Object>();
		List<Bms>bills = bmsrepo.findAll();
		Iterator billsItr = bills.iterator();
		while(billsItr.hasNext()) {
			Bms bms = (Bms) billsItr.next();
			Optional<Customer> c = customerRepo.findById(Integer.valueOf(String.valueOf(bms.getCustomerId())));
			bms.setCustomerName(c.get().getFname()+" "+c.get().getLname());
			

			Optional<Product> p = productRepo.findById(Integer.valueOf(String.valueOf(bms.getProductId())));
			bms.setProductName(p.get().getPname());
		}
		responseMap.put("bms", bills);
		return responseMap;
	}

	@Override
	public List<Bms> getDetails() {	
		// TODO Auto-generated method stub
		List<Bms> bmsList = new ArrayList<Bms>();
		
		return bmsList;
	}

	@Override
	public HashMap<String, Object> getDropValues() {
		// TODO Auto-generated method stub
		HashMap<String,Object>responseMap=new HashMap<String, Object>();
		
		responseMap.put("customers", customerRepo.findAll());
		responseMap.put("products", productRepo.findAll());
		
		return responseMap;
	}

	
}
