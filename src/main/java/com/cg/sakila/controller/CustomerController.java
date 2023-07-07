package com.cg.sakila.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sakila.entity.Address;
import com.cg.sakila.entity.Customer;
import com.cg.sakila.entity.myEntity;
import com.cg.sakila.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
@Validated
public class CustomerController {
	
	@Autowired
	private CustomerService customerservice;
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllCustomers(){
		return new ResponseEntity<>(customerservice.findAllCustomers(), HttpStatus.OK);
	}
	
	//working
	@GetMapping("/lastname/{ln}")
    public ResponseEntity<List<Customer>> searchCustomersByLastName(@PathVariable("ln") String lastName) {
        List<Customer> customers = customerservice.findCustomersByLastName(lastName);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
	
	//working
	@GetMapping("/firstname/{fn}")
    public ResponseEntity<List<Customer>> searchCustomersByFirstName(@PathVariable("fn") String firstName) {
        List<Customer> customers = customerservice.findCustomersByFirstName(firstName);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
	
	//working
	@GetMapping("/email/{email}")
    public ResponseEntity<Customer> searchCustomerByEmail(@PathVariable("email") String email) {
        Customer customer = customerservice.findCustomerByEmail(email);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
	
	//working
	@GetMapping("/city/{city}")
    public List<Customer> getCustomersByCity(@PathVariable("city") String city) {
        return customerservice.getCustomersByCity(city);
    }
	
	//working
	@GetMapping("/country/{country}")
    public List<Customer> getCustomersByCountry(@PathVariable("country") String country) {
        return customerservice.getCustomersByCountry(country);
    }
	
	//working
	@PutMapping("/{id}/address")
    public ResponseEntity<Customer> assignAddressToCustomer(@PathVariable("id") short customerId,
            @RequestBody Address address) {
        Customer customer = customerservice.assignAddressToCustomer(customerId, address);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
	
	//working
    @GetMapping("/active")
    public ResponseEntity<List<Customer>> searchActiveCustomers() {
        List<Customer> customers = customerservice.findActiveCustomers();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    
    //working
    @GetMapping("/inactive")
    public ResponseEntity<List<Customer>> searchInactiveCustomers() {
        List<Customer> customers = customerservice.findInactiveCustomers();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    
    //working
    @GetMapping("/phone/{phone}")
    public ResponseEntity<Customer> searchCustomerByPhone(@PathVariable("phone") String phone) {
        Customer customer = customerservice.findCustomerByPhone(phone);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    
    @PutMapping("/update/fn/{id}")
    public ResponseEntity<Customer> updateCustomerFirstName(
            @PathVariable("id") Short id,
            @RequestBody Map<String, String> requestBody) {
        String firstName = requestBody.get("firstName");
        if (firstName == null || firstName.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Customer updatedCustomer = customerservice.updateCustomerFirstName(id, firstName);
        return ResponseEntity.ok(updatedCustomer);
    }
    
    @PutMapping("/update/ln/{id}")
    public ResponseEntity<Customer> updateCustomerLastName(
            @PathVariable("id") Short id,
            @RequestBody Map<String, String> requestBody) {
        String lastName = requestBody.get("lastName");
        if (lastName == null || lastName.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Customer updatedCustomer = customerservice.updateCustomerLastName(id, lastName);
        return ResponseEntity.ok(updatedCustomer);
    }
    
    
    @PutMapping("/update/email/{id}")
    public ResponseEntity<Customer> updateCustomerEmail(
            @PathVariable("id") Short id,
            @RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        if (email == null || email.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Customer updatedCustomer = customerservice.updateCustomerEmail(id, email);
        return ResponseEntity.ok(updatedCustomer);
    }
    

    @PutMapping("/update/store/{id}")
    public ResponseEntity<Customer> assignStoreToCustomer(
            @PathVariable("id") Short id,
            @RequestParam("storeId") Byte storeId) {
        Optional<Customer> updatedCustomer = customerservice.assignStoreToCustomer(id, storeId);
        if (updatedCustomer.isPresent()) {
            return new ResponseEntity<>(updatedCustomer.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping("/update/phone/{id}")
    public ResponseEntity<Customer> updateCustomerPhone(
            @PathVariable("id") Short customerId,
            @RequestParam("phone") String phone) {
        Customer updatedCustomer = customerservice.updateCustomerPhone(customerId, phone);
        if (updatedCustomer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }
    //working
    @PostMapping("/post")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        Customer addedCustomer = customerservice.addCustomer(customer);
        if (addedCustomer != null) {
            return new ResponseEntity<>("Record Created Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to Create Record", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
//    @GetMapping("/info")
//    public List<Object[]> getCustomerInfo(){
//    	return customerservice.getCustomerInfo();
//    }
    
//    @GetMapping("/dummy")
//    public ResponseEntity<List<myEntity>> getName(){
//    	return new ResponseEntity<List<myEntity>>(customerservice.getCustomerName(),HttpStatus.OK);
//    }
	
}
