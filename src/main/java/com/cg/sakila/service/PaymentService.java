package com.cg.sakila.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.cg.sakila.entity.Payment;
import com.cg.sakila.entity.PaymentDTO;

public interface PaymentService {

	//List<PaymentDTO> getPaymentSumByDate();
	//List<Object[]> getPaymentSumBYDate();
	
	//List<PaymentDTO> getCumulativeRevenueByDate();
	//returned with object array by we have to change to DTO class
	Collection<Object[]> calculateCumulativeRevenueOfAllStores();
	//public Collection<Object[]> calculateCumulativeRevenueOfAllFilms();
	
    public List<Object[]> getPaymentsWithCumulativeRevenue(Byte storeId);
}
