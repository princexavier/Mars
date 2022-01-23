package com.bms.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.entities.Report;
import com.bms.repo.BmsRepo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class ReportServiceImpl implements ReportService{

	@Autowired
	BmsRepo bmsrepo;
	@Override
	public HashMap<String, Object> getReports(String requestData) {
		HashMap<String,Object>responsemap = new HashMap<String,Object>();

		try {
			System.out.println(requestData);
			
			ObjectMapper om = new ObjectMapper();
			JsonNode jsonNode = om.readTree(requestData);
			System.out.println(jsonNode.get("date").asText());
			List<Object>list =  bmsrepo.findAllByFilter(jsonNode.get("date").asText());
			Iterator itr = list.iterator();
			List<Report>reportList = new ArrayList<>();
			while(itr.hasNext()) {
				Object[] obj = (Object[]) itr.next();
				Report report = new Report();
				report.setCustomerName(obj[0].toString());
				report.setProductName(obj[1].toString());
				report.setUnitPrice(new BigDecimal(obj[2].toString()));
				report.setQuantity(new BigDecimal(obj[3].toString()));
				report.setTotalAmt(new BigDecimal(obj[7].toString()));
				report.setCustomerAmt(new BigDecimal( obj[4].toString()));
				report.setBalanceAmt(new BigDecimal(obj[5].toString()));
				report.setDateCreated(obj[6].toString());
				reportList.add(report);
			}
			responsemap.put("data",reportList);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return responsemap;
	}

}
