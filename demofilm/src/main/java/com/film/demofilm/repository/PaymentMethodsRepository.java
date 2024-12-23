package com.film.demofilm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.film.demofilm.domain.dto.PaymentMethodsDto;
import com.film.demofilm.entity.PaymentMethods;

@Repository
public interface PaymentMethodsRepository extends JpaRepository<PaymentMethods, Integer> {

	@Query("Select pm.pmId FROM Cart c INNER JOIN PaymentMethods pm ON c.pm.idCart=pm.cartId WHERE pm.pmId=:pmId")
	PaymentMethods getCartpaymentMethod(Integer pmId) throws Exception;

	@Query("SELECT p FROM PaymentMethods p WHERE p.pmId=:pmId")
	PaymentMethodsDto getPayMethodById(Integer pmId);

	@Query("Select p From Cart cart INNER JOIN User cust ON cust.cart.customerId=cust.id"
			+ "INNER JOIN PaymentMethods pm ON cart.pm.idCart=cart.cartId" + "WHERE cust.id=:?1 AND pm.pmId=:?2")
	PaymentMethodsDto getUserPaymentMethods(Integer id, Integer pmId);

}
