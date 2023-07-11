package com.cg.sakila.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sakila.entity.Address;
import com.cg.sakila.entity.Customer;
import com.cg.sakila.entity.Staff;
import com.cg.sakila.entity.Store;
import com.cg.sakila.service.StoreService;

@RestController
@RequestMapping("/api/store")
public class StoreController {
	private final StoreService storeService;

	@Autowired
	public StoreController(StoreService storeService) {
		this.storeService = storeService;
	}

	//working
	@GetMapping("/address")
	public List<Address> fetchAllAddress() {
		return this.storeService.fetchAllAddress();
	}

	@PostMapping("/post")
	public ResponseEntity<String> addStore(@RequestBody Store store) {
		storeService.addStore(store);
		return ResponseEntity.status(HttpStatus.CREATED).body("Record Created Successfully");
	}

	@PutMapping("/{id}/address")
	public ResponseEntity<Store> assignAddressToStore(@PathVariable("id") byte storeId, @RequestBody Address address) {
		storeService.assignAddressToStore(storeId, address);
		Store store = storeService.getStoreById(storeId);
		return ResponseEntity.ok(store);
	}

	//working
	@GetMapping("/city/{city}")
	public ResponseEntity<List<Store>> getStoresByCity(@PathVariable("city") String city) {
		List<Store> stores = storeService.getStoresByCity(city);
		return ResponseEntity.ok(stores);
	}

	//working
	@GetMapping("/country/{country}")
	public ResponseEntity<List<Store>> getStoresByCountry(@PathVariable("country") String country) {
		List<Store> stores = storeService.getStoresByCountry(country);
		return ResponseEntity.ok(stores);
	}

	//working
	@GetMapping("/phone/{phone}")
	public ResponseEntity<Store> getStoreByPhoneNumber(@PathVariable("phone") String phone) {
		Store store = storeService.getStoreByPhoneNumber(phone);
		return ResponseEntity.ok(store);
	}

	// working fine
	@PutMapping("/update/phone/{id}")
	public ResponseEntity<Store> updateStorePhoneNumber(@PathVariable("id") byte storeId, @RequestBody String phone) {
		storeService.updateStorePhoneNumber(storeId, phone);
		Store store = storeService.getStoreById(storeId);
		return ResponseEntity.ok(store);
	}

	//working
	@PutMapping("/{id}/manager")
	public ResponseEntity<Store> assignManagerToStore(@PathVariable("id") byte managerStaffId,
			@RequestBody Staff manager) {
		storeService.assignManagerToStore(managerStaffId, manager);
		Store store = storeService.findStoreByManagerStaffId(managerStaffId);
		return ResponseEntity.ok(store);
	}

	//working
	@GetMapping("/staff/{id}")
	public ResponseEntity<List<Staff>> getAllStaffByStoreId(@PathVariable("id") byte storeId) {
		List<Staff> staffList = storeService.getAllStaffByStoreId(storeId);
		return ResponseEntity.ok(staffList);
	}

	//working
	@GetMapping("/customer/{id}")
	public ResponseEntity<List<Customer>> getCustomersByStoreId(@PathVariable("id") Byte storeId) {
		List<Customer> customers = storeService.getCustomersByStoreId(storeId);
		return ResponseEntity.ok(customers);
	}    
	
	//working
	@GetMapping("/manager/{id}")
	public ResponseEntity<List<Staff>> getManagerDetailsByStoreId(@PathVariable("id") byte storeId) {
		List<Staff> managers = storeService.getManagerDetailsByStoreId(storeId);
		return ResponseEntity.ok(managers);
	}
	   
	//working
	@GetMapping("/managers")
	public ResponseEntity<List<Staff>> getAllManagers() {
		List<Staff> managers = storeService.getAllManagers();
		return ResponseEntity.ok(managers);
	}
}