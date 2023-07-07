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
import com.cg.sakila.entity.PaymentDTO;

@Repository
@Component
@Transactional
public interface PaymentRepository extends JpaRepository<Payment,Integer> {

	//@Query("SELECT new map(p.paymentDate as paymentDate, p.amount as amount) FROM Payment p")
	//@Query("select new map(p.paymentDate as paymentDate, SUM(p.amount) AS totalAmount) from payment p group by p.paymentDate ")
	//@Query("select p.payment_date,p.amount,sum(p.amount) over(order by payment_date rows unbounding preceding) total from payment) 
//	 @Query("SELECT p.paymentDate, p.amount, SUM(p.amount) OVER (ORDER BY p.paymentDate) "
//	            + "FROM (SELECT CAST(p.paymentDate AS DATE) AS paymentDate, SUM(p.amount) AS amount "
//	            + "FROM Payment p GROUP BY CAST(p.paymentDate AS DATE)) p "
//	            + "ORDER BY p.paymentDate")
	 //@Query("SELECT payment_date, amount, sum(amount) OVER (ORDER BY payment_date)FROM (SELECT CAST(payment_date AS DATE) AS payment_date, SUM(amount) AS amount FROM payment GROUP BY CAST(payment_date AS DATE)) p ORDER BY payment_date")
//	 @Query(value = "SELECT p.paymentDate, p.amount, SUM(p.amount) OVER (ORDER BY p.paymentDate) "
//	            + "FROM Payment p "
//	            + "GROUP BY p.paymentDate, p.amount "
//	            + "ORDER BY p.paymentDate")
//	List<PaymentDTO> getPaymentSumByDate();
//	@Query("SELECT p.paymentDate, p.amount, (SELECT SUM(p2.amount) FROM Payment p2 WHERE p2.paymentDate <= p.paymentDate) "
//		       + "FROM Payment p "
//		       + "GROUP BY p.paymentDate, p.amount "
//		       + "ORDER BY p.paymentDate")
	
//	@Query("SELECT CAST(p.paymentDate AS DATE), p.amount, SUM(p.amount) "
//		       + "FROM (SELECT p.paymentDate AS paymentDate, SUM(p.amount) AS amount "
//		       + "      FROM Payment p "
//		       + "      GROUP BY p.paymentDate) p "
//		       + "GROUP BY CAST(p.paymentDate AS DATE), p.amount "
//		       + "ORDER BY CAST(p.paymentDate AS DATE)")
	/*
//	@Query("SELECT p.paymentDate, p.amount,(SELECT SUM(p2.amount) FROM Payment p2 WHERE p2.paymentDate <= p.paymentDate) "
//		       + "FROM Payment p "
//		       + "GROUP BY p.paymentDate, p.amount "
//		       + "ORDER BY p.paymentDate")
//	List<PaymentDTO> getPaymentSumByDate(); */
	
//	@Query("SELECT p.paymentDate, p.amount, SUM(p.amount) OVER (ORDER BY p.paymentDate) " +
//            "FROM (" +
//            "  SELECT CAST(p.paymentDate AS DATE) AS paymentDate, SUM(p.amount) AS amount " +
//            "  FROM Payment p " +
//            "  GROUP BY CAST(p.paymentDate AS DATE)" +
//            ") p " +
//            "ORDER BY p.paymentDate")
//	@Query("")
//	List<PaymentDTO> getPaymentSumByDate();
	
//	 @Query("SELECT p.rental.inventory.store.address.address, SUM(p.amount) " +
//	            "FROM Payment p " +
//	            "WHERE p.rental.inventory.film.filmId = :filmId " +
//	            "GROUP BY p.rental.inventory.store.address.address")
//	    List<Object[]> calculateRevenueByFilmStoreWise(@Param("filmId") int filmId);
	
	
//	@Query("SELECT p.paymentDate, p.amount, SUM(p.amount) OVER (ORDER BY p.paymentDate) " +
//          "FROM (" +
//          "  SELECT CAST(p.paymentDate AS DATE) AS paymentDate, SUM(p.amount) AS amount " +
//          "  FROM Payment p " +
//          "  GROUP BY CAST(p.paymentDate AS DATE)" +
//          ") p " +
//          "ORDER BY p.paymentDate")
//	List<PaymentDTO> getPaymentSumByDate();
//	 @Query(value = "SELECT payment_date, SUM(amount) " +
//	            "FROM Payment " +
//	            "GROUP BY payment_date " +
//	            "ORDER BY payment_date ASC", nativeQuery = true)
//	    List<Object[]> getCumulativeRevenueByDate();
	
//	 @PersistenceContext
//	 private EntityManager entityManager;
//
//	    public List<Object[]> executeQuery(String query) {
//	        Query nativeQuery = entityManager.createNativeQuery(query);
//	        return nativeQuery.getResultList();
//	    }
}
