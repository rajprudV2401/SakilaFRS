package com.cg.sakila.service;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sakila.entity.Payment;
import com.cg.sakila.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	private PaymentRepository paymentRepository;
	@Autowired
	public PaymentServiceImpl(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	EntityManager entityManager;
	@Autowired
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Collection<Object[]> calculateCumulativeRevenueOfAllStores(){
		
		String query = "SELECT DATE(payment_date) AS payment_date, SUM(amount) AS amount " +
            "FROM Payment " +
            "GROUP BY DATE(payment_date) " +
            "ORDER BY DATE(payment_date)";

		List<Object[]> results = entityManager.createQuery(query, Object[].class).getResultList();
		List<Object[]> cumulativeResults = new ArrayList<>();

		BigDecimal cumulativeRevenue = BigDecimal.ZERO;
		for(Object[] result : results) {
			Date paymentDate = (Date) result[0];
			BigDecimal amount = (BigDecimal) result[1];
			cumulativeRevenue = cumulativeRevenue.add(amount);
			Object[] cumulativeResult = { paymentDate, amount, cumulativeRevenue };
			cumulativeResults.add(cumulativeResult);
		}
		return cumulativeResults;
	}

	@Override
	public List<Object[]> getPaymentsWithCumulativeRevenue(Byte storeId){
		String jpqlQuery = "SELECT p.paymentDate, p.amount, s.storeId, " +
             "(SELECT SUM(p2.amount) FROM Payment p2 JOIN p2.staff s2 JOIN s2.store st2 WHERE s2.storeId = :storeId AND p2.paymentDate <= p.paymentDate) AS cumulativeRevenue " +
             "FROM Payment p " +
             "JOIN p.staff s " +
             "JOIN s.store st " +
             "WHERE s.storeId = :storeId " +
             "ORDER BY p.paymentDate";
		TypedQuery<Object[]> query = entityManager.createQuery(jpqlQuery, Object[].class);
		query.setParameter("storeId", storeId);
		return query.getResultList();
	}

	public List<Object[]> calculateCumulativeRevenueByDateAndStore(Byte storeId) {
		return paymentRepository.calculateCumulativeRevenueByDateAndStore(storeId);
	}
}
    
