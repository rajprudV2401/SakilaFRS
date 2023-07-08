package com.cg.sakila.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.cg.sakila.entity.Payment;
import com.cg.sakila.entity.PaymentDTO;

public interface PaymentService {

	Collection<Object[]> calculateCumulativeRevenueOfAllStores();
    public List<Object[]> getPaymentsWithCumulativeRevenue(Byte storeId);
    public List<Object[]> calculateCumulativeRevenueByDateAndStore(Byte storeId);
}
