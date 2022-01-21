package com.bms.entities;

import java.math.BigDecimal;

public class Report {

	private String customerName;
	private BigDecimal quantity;
	private BigDecimal unitPrice;
	private String productName;
	private BigDecimal customerAmt;
	private BigDecimal balanceAmt;
	private BigDecimal totalAmt;

	private String dateCreated;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getCustomerAmt() {
		return customerAmt;
	}

	public void setCustomerAmt(BigDecimal customerAmt) {
		this.customerAmt = customerAmt;
	}

	public BigDecimal getBalanceAmt() {
		return balanceAmt;
	}

	public void setBalanceAmt(BigDecimal balanceAmt) {
		this.balanceAmt = balanceAmt;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public BigDecimal getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}

	@Override
	public String toString() {
		return "Report [customerName=" + customerName + ", quantity=" + quantity + ", unitPrice=" + unitPrice
				+ ", productName=" + productName + ", customerAmt=" + customerAmt + ", balanceAmt=" + balanceAmt + "]";
	}

}
