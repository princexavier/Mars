package com.bms.services;

import java.util.HashMap;
import java.util.List;

import com.bms.entities.Bms;

public interface BmsService {

	public List<Bms> addBmsList(String requestData);

	public HashMap<String, Object> getBmsList();
	
	public List<Bms> getDetails();

	public HashMap<String, Object> getDropValues();

}
