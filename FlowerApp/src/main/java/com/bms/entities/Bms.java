package com.bms.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity(name="bms")
public class Bms {

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bms_seq")
@Column(name = "id")
private Long id;

@Column(name="quantity")
private Integer quantity;


@Column(name="unit_price")
@JsonProperty("unitPrice")
private BigDecimal unitPrice;

@Column(name="customer_amt")
@JsonProperty("customerAmt")
private BigDecimal customerAmt;

@Column(name="total_amt")
@JsonProperty("totalAmt")
private BigDecimal totalAmt;
@Column(name="balance_amt")
@JsonProperty("balanceAmt")
private BigDecimal balanceAmt;

@Column(name="date_created")
@JsonProperty("dateCreated")
private Date dateCreated;

@Column(name = "customer_id")
@JsonProperty("customerId")
private Long customerId;

@Column(name = "product_id")
@JsonProperty("productId")
private Long productId;

private String customerName;
private String productName;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
public BigDecimal getUnitPrice() {
	return unitPrice;
}
public void setUnitPrice(BigDecimal unitPrice) {
	this.unitPrice = unitPrice;
}
public BigDecimal getCustomerAmt() {
	return customerAmt;
}
public void setCustomerAmt(BigDecimal customerAmt) {
	this.customerAmt = customerAmt;
}
public BigDecimal getTotalAmt() {
	return totalAmt;
}
public void setTotalAmt(BigDecimal totalAmt) {
	this.totalAmt = totalAmt;
}
public BigDecimal getBalanceAmt() {
	return balanceAmt;
}
public void setBalanceAmt(BigDecimal balanceAmt) {
	this.balanceAmt = balanceAmt;
}
public Date getDateCreated() {
	return dateCreated;
}
public void setDateCreated(Date dateCreated) {
	this.dateCreated = dateCreated;
}

public Long getCustomerId() {
	return customerId;
}
public void setCustomerId(Long customerId) {
	this.customerId = customerId;
}
public Long getProductId() {
	return productId;
}
public void setProductId(Long productId) {
	this.productId = productId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
@Override
public String toString() {
	return "Bms [id=" + id + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", customerAmt=" + customerAmt
			+ ", totalAmt=" + totalAmt + ", balanceAmt=" + balanceAmt + "]";
}


}
