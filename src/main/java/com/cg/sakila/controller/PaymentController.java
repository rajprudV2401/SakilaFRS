package com.cg.sakila.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sakila.entity.Payment;
import com.cg.sakila.service.PaymentService;

@RestController
@RequestMapping("api/payment")
public class PaymentController {

	private PaymentService paymentService;

	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@GetMapping("/revenue/datewise")
    public Collection<Object[]> getDatewiseRevenue() {
        return paymentService.calculateCumulativeRevenueOfAllStores();
    }
    
    @GetMapping("/{id}")
    public List<Object[]> getStoreRevenueDatewise(@PathVariable("id") Byte storeId) {
        return paymentService.getPaymentsWithCumulativeRevenue(storeId);
    }
    
    @GetMapping("/revenue/datewise/store/{id}")
    public ResponseEntity<List<Object[]>> getRevenueByDateAndStore(@PathVariable("id") Byte storeId) {
        List<Object[]> revenueList = paymentService.calculateCumulativeRevenueByDateAndStore(storeId);
        return ResponseEntity.ok(revenueList);
    }
}
