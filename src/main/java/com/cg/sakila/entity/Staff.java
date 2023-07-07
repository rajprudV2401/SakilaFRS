package com.cg.sakila.entity;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="staff")
public class Staff {

	@Id
	@Column(name="staff_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Byte staffId;
	
	@Column(name="first_name",nullable = false)
	private String firstName;
	
	@Column(name="last_name",nullable = false)
	private String lastName;
	
	@ManyToOne
	@JoinColumn(name="address_id",nullable=false)
	private Address address;
	
	@Column(name="picture")
	private Byte[] picture;
	
	@Column(name="email")
	private String email;
	
	@ManyToOne
	@JoinColumn(name="store_id",nullable=false)
	private Store store;
	
	@Column(name="active",nullable=false)
	private Integer active;
	
	//we create seperate file for theses
//	@Column(name="username")
//	private String username;
//	
//	@Column(name="password")
//	private String password;
	
	@Column(name="last_update",nullable = false)
	private Timestamp lastUpdate;
	
	
}
