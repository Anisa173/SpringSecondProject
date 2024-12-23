package com.film.demofilm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.film.demofilm.entity.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

	@Query("SELECT cartI.ciId,scFilm.id"
			+ "FROM CartItem cartI INNER JOIN SubscribedFilm scFilm ON scFilm.cartI.subscribeFilmId = scFilm.id"
			+ " WHERE cartI.ciId=:?2 AND scFilm.id=:?2")
	CartItem getCartItemById(Integer ciId);

}
