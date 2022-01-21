package com.bms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_seq1")
	@Column(name = "id")
	private int id;

	@Column(name = "pname")
	@JsonProperty("productName")
	private String productName;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return productName;
	}

	public void setPname(String pname) {
		this.productName = pname;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + productName + "+ bmsList +]";
	}

}
