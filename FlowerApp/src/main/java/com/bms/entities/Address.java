package com.bms.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;


@Embeddable
public class Address {


	
	@Column(name = "door_no")
	private int doornNo;
	
	@Column(name = "street_name")
	private String streetName;
	
	@Column(name = "place")
	private String place;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "pincode")
	private int pinCode;
	
	@ManyToOne
	private Customer customer;

	

	public int getDoornNo() {
		return doornNo;
	}

	public void setDoornNo(int doornNo) {
		this.doornNo = doornNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [ doornNo=" + doornNo + ", streetName=" + streetName + ", place=" + place
				+ ", district=" + district + ", state=" + state + ", pinCode=" + pinCode + ", customer=" + customer
				+ "]";
	}
	
	
}
