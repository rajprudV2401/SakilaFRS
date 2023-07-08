package com.cg.sakila.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.sakila.entity.Customer;
import com.cg.sakila.entity.myEntity;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Short>{
	
	List<Customer> findByLastName(String lastName);
	List<Customer> findByFirstName(String firstName);
	Customer findByEmail(String email);
	List<Customer> findByActive(int active);
	List<Customer> findByAddress_City_City(String city);
	List<Customer> findByAddress_City_Country_Country(String country);
	Customer findByAddressPhone(String phone);
	
}
