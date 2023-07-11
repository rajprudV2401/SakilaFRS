package com.cg.sakila;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.sakila.entity.Actor;
import com.cg.sakila.entity.Customer;
import com.cg.sakila.repository.ActorRepository;
import com.cg.sakila.repository.CustomerRepository;

//@SpringBootTest
class SakilaApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ActorRepository actorRepository;
	
//	//from actor
//	
//	//working
//	@Test
//	public void testActorReadAll() {
//		List<Actor> list=actorRepository.findAll();
//		assertThat(list).size().isGreaterThan(0);
//	}
//	
//	//working
//	@Test
//	public void testActorRead() {
//		Short i=2;
//		int j=(int)i;
//		Optional<Actor> ac=actorRepository.findById(i);
//		String firstName=ac.get().getFirstName();
//		assertEquals("NICK",firstName);
//	}
//	
//	//working
//	@Test
//	public void testActorByFirstName() {
//		List<Actor> list=actorRepository.findByFirstName("NICK");
//		
//		String name="NICK";
//		assertEquals(name, list.get(0).getFirstName());
//		
//	}
//	
//	//from customer
//	//working
//	@Test
//	public void testCustomerReadAll() {
//		List<Customer> allCustomers=customerRepository.findAll();
//		assertThat(allCustomers.size()).isGreaterThan(0);
//	}
//	
//	//working
//	@Test
//	public void testCustomerByEmail() {
//		Customer customer=customerRepository.findByEmail("ROSE.HOWARD@sakilacustomer.org");
//		String fname="ROSE";
//		assertEquals(fname,customer.getFirstName());
//	}
//	
//	//from film
//	
//	//public void testFilm
//	
//	
	
	
	
}
