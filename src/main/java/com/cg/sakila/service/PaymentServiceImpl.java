package com.cg.sakila.service;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sakila.entity.Payment;
import com.cg.sakila.entity.PaymentDTO;
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


	

//	@Override
//	public List<PaymentDTO> getPaymentSumByDate() {
//		paymentRepository.getPaymentSumByDate().forEach(System.out::print);
//		return null;
		
		
//		List<Object[]> results=paymentRepository.getPaymentSumByDate();
//		List<PaymentDTO> dtos=new ArrayList<>();
//		for(Object[] result: results) {
//			PaymentDTO dto=new PaymentDTO();
//			dto.setPaymentDate((Timestamp)result[0]);
//			dto.setAmount((BigDecimal) result[1]);
//			dto.setCumulativeSum((BigDecimal)result[2]);
//			dtos.add(dto);
//		}
//		return dtos;
		//return paymentRepository.getPaymentSumByDate();

//	@Override
//	public List<Object[]> getPaymentSumBYDate() {
//		paymentRepository.getPaymentSumByDate();
//	}
	
//    @Override
//    public List<PaymentDTO> getCumulativeRevenueByDate() {
//        List<Object[]> results = paymentRepository.getCumulativeRevenueByDate();
//
//        List<PaymentDTO> revenueList = new ArrayList<>();
//        BigDecimal cumulativeRevenue = BigDecimal.ZERO;
//
//        for (Object[] result : results) {
//            Timestamp paymentDate = (java.sql.Timestamp) result[0];
//            BigDecimal amount = (BigDecimal) result[1];
//            cumulativeRevenue = cumulativeRevenue.add(amount);
//
//            PaymentDTO revenueDTO = new PaymentDTO(cumulativeRevenue,paymentDate);
//            revenueList.add(revenueDTO);
//            
//        }
//
//        return revenueList;
//    }

	
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
}
    
