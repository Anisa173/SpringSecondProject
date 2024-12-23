package com.film.demofilm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.film.demofilm.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	@Query("SELECT c.id,cart.cartId,cartItem.ciId,pm.pmId" + " FROM Cart cart INNER JOIN User c ON  c.cart.customerId=c.id"
			+ "INNER JOIN CartItem cartItem ON cartItem.cart.IdCartItem=cartItem.ciId "
			+ "INNER JOIN PaymentMethods pm ON cart.pm.idCart=cart.cartId"
			+ "WHERE c.id=:?1 AND pm.pmId=:?2 AND cart.cartId =:?3 ")
	Cart getCartByUserId(Integer id,Integer cartId, Integer pmId);

	

}
