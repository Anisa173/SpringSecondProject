package com.film.demofilm.service;

import java.util.List;

import com.film.demofilm.domain.dto.CartDto;
import com.film.demofilm.entity.Cart;

import jakarta.validation.Valid;

public interface CartService {

	CartDto preparePayment(@Valid CartDto cDto, Integer id, Integer ciId, Integer pmId) throws Exception;

	Cart getCartByUserId(Integer id, Integer cartId, Integer pmId) throws Exception;

	List<CartDto> getAllCarts() throws Exception;
}
