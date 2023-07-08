package com.cg.sakila.entity;

import java.sql.Timestamp;
import java.util.Date;

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
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private Short customerId;
	
	@Column(name="store_id",nullable=false)
	private Byte storeId;
	
	@Column(name="first_name",nullable=false)
	private String firstName;
	
	@Column(name="last_name",nullable=false)
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	@Column(name = "active", nullable = false)
	private int active;
	
	@Column(name="create_update")
	@Temporal(TemporalType.TIME)
	private Date createDate;
    
    @Column(name="last_update")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	
}
