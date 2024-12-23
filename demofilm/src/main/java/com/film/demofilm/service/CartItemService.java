package com.film.demofilm.service;

import java.util.List;

import com.film.demofilm.domain.dto.CartItemDto;
import com.film.demofilm.entity.CartItem;

import jakarta.validation.Valid;

public interface CartItemService {

	CartItem addToCartItem(@Valid CartItemDto cartItemDto, Integer id, Integer idFilm) throws Exception;

	CartItem getCartItemById(Integer ciId) throws Exception;

	List<CartItemDto> getAllCartItemById() throws Exception;

}
