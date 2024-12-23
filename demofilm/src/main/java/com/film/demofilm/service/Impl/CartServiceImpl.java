package com.film.demofilm.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.film.demofilm.domain.dto.CartDto;
import com.film.demofilm.domain.mapper.CartMapper;
import com.film.demofilm.entity.Cart;
import com.film.demofilm.entity.PaymentMethods;
import com.film.demofilm.repository.CartRepository;
import com.film.demofilm.service.CartItemService;
import com.film.demofilm.service.CartService;
import com.film.demofilm.service.PaymentMethodsService;
import com.film.demofilm.service.UserService;
import jakarta.validation.Valid;

@Validated
@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private final CartMapper cartMapper;
	@Autowired
	private final CartRepository cartRepository;
	@Autowired
	private final CartItemService ciService;
	@Autowired
	private final PaymentMethodsService pmService;
	@Autowired
	private final UserService uService;

	public CartServiceImpl(CartMapper cartMapper, CartRepository cartRepository, CartItemService ciService,
			PaymentMethodsService pmService, UserService uService) {
		this.cartMapper = cartMapper;
		this.cartRepository = cartRepository;
		this.ciService = ciService;
		this.pmService = pmService;
		this.uService = uService;
	}

//add toCart--cartItem
	@Override
	public CartDto preparePayment(@Valid CartDto cDto, Integer id, Integer ciId, Integer pmId) throws Exception {
		var customer = uService.findUserCartById(id);
		var cartI = ciService.getCartItemById(ciId);
		var payMethods = pmService.getCartpaymentMethod(pmId);
		var result = cartMapper.toEntity(cDto);
		result.setCustomer(customer);
		result.setCartItem(cartI);
		result.setPMethod(((List<PaymentMethods>) payMethods));
		return cartMapper.toDto(cartRepository.save(result));
	}

	@Override
	public Cart getCartByUserId(Integer id, Integer cartId, Integer pmId) throws Exception {
		return cartRepository.getCartByUserId(id, cartId, pmId);
	}

	@Override
	public List<CartDto> getAllCarts() throws Exception {
		return cartRepository.findAll().stream().map(c -> cartMapper.toDto(c)).collect(Collectors.toList());
	}

}
