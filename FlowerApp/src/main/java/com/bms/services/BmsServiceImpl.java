package com.bms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.entities.Bms;
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
	public List<Bms> getBmsList() {
		// TODO Auto-generated method stub
		return bmsrepo.findAll();
	}

	@Override
	public List<Bms> getDetails() {	
		// TODO Auto-generated method stub
		List<Bms> bmsList = new ArrayList<Bms>();
		
		return bmsList;
	}

	
}
