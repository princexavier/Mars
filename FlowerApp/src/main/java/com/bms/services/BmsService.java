package com.bms.services;

import java.util.List;

import com.bms.entities.Bms;

public interface BmsService {

	public List<Bms> addBmsList(String requestData);

	public List<Bms> getBmsList();
	
	public List<Bms> getDetails();

}
