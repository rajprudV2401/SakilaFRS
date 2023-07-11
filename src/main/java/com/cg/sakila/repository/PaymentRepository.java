package com.cg.sakila.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cg.sakila.entity.Payment;

@Repository
@Component
@Transactional
public interface PaymentRepository extends JpaRepository<Payment,Integer> {

	 @Query(value = "SELECT p.paymentDate, SUM(p.amount) AS cumulative_revenue " +
	            "FROM Payment p " +
	            "INNER JOIN Rental r ON p.rentalId = r.rentalId " +
	            "INNER JOIN Inventory i ON r.inventoryId = i.inventoryId " +
	            "INNER JOIN store s ON i.storeId = s.storeId " +
	            "WHERE s.storeId = :storeId " +
	            "GROUP BY p.paymentDate " +
	            "ORDER BY p.paymentDate",
	            nativeQuery = true)
    List<Object[]> calculateCumulativeRevenueByDateAndStore(@Param("storeId") Byte storeId);

}
