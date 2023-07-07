package com.cg.sakila.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//for rental entity
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="rental")
public class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rental_id")
	private Integer rentalId;
	
	@Column(name="rental_date",nullable = false)
	private Timestamp rentalDate;
	
	@ManyToOne
	@JoinColumn(name="inventory_id")
	private Inventory inventory;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@Column(name="return_date")
	private Timestamp returnDate;
	
	@ManyToOne
	@JoinColumn(name="staff_id")
	private Staff staff;
	
	@Column(name="last_update",nullable = false)
	private Timestamp lastUpdate;
}
