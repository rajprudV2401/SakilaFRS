package com.cg.sakila.entity;

import java.math.BigDecimal;
import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//@Getter
//@Setter
//@Data
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class PaymentDTO {

	/*@Column(name="payment_date")
	private Timestamp paymentDate;
	@Column(name="amount")
	private BigDecimal amount;
	@Column(name="cumulativesum")
	private BigDecimal cumulativeSum;
	
	public PaymentDTO() {
		// TODO Auto-generated constructor stub
	}

	public Timestamp getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getCumulativeSum() {
		return cumulativeSum;
	}

	public void setCumulativeSum(BigDecimal cumulativeSum) {
		this.cumulativeSum = cumulativeSum;
	}

	@Override
	public String toString() {
		return "PaymentDTO [paymentDate=" + paymentDate + ", amount=" + amount + ", cumulativeSum=" + cumulativeSum
				+ "]";
	}
	*/
	//custom columns 
	private BigDecimal cumulativeRevenue;
	
	private java.sql.Timestamp paymentDate;
	
	public BigDecimal getCumulativeRevenue() {
		return cumulativeRevenue;
	}
	public void setCumulativeRevenue(BigDecimal cumulativeRevenue) {
		this.cumulativeRevenue = cumulativeRevenue;
	}
	public java.sql.Timestamp getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(java.sql.Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}
	public PaymentDTO(BigDecimal cumulativeRevenue, java.sql.Timestamp paymentDate) {
		super();
		this.cumulativeRevenue = cumulativeRevenue;
		this.paymentDate = paymentDate;
	}
	public PaymentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
