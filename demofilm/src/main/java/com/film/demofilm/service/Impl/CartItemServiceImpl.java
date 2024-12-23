package com.film.demofilm.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.film.demofilm.domain.dto.CartItemDto;
import com.film.demofilm.domain.mapper.CartItemMapper;
import com.film.demofilm.entity.CartItem;
import com.film.demofilm.repository.CartItemRepository;
import com.film.demofilm.service.CartItemService;
import com.film.demofilm.service.SubscribedFilmsService;
import jakarta.validation.Valid;

@Validated
@Service
public class CartItemServiceImpl implements CartItemService {
	@Autowired
	private final SubscribedFilmsService subService;

	@Autowired
	private final CartItemRepository cartItemR;

	@Autowired
	private final CartItemMapper cartIMapper;


	
	public CartItemServiceImpl(SubscribedFilmsService subService, CartItemRepository cartItemRepo,
			CartItemMapper cartIMapper) {

		this.subService = subService;
		this.cartItemR = cartItemRepo;
		this.cartIMapper = cartIMapper;
	}

	@Override
	public CartItem addToCartItem(@Valid CartItemDto cartItemDto, Integer id,Integer idFilm)
			throws Exception {
		var subFilm = subService.getSubscribedFilmPaidByUserId(id, idFilm);
		var cart = cartIMapper.toEntity(cartItemDto);
		cart.setSubscriptionf(subFilm);

		return cartItemR.save(cart);
	}

	@Override
	public CartItem getCartItemById(Integer ciId) throws Exception {
		
		return cartItemR.getCartItemById(ciId);
	}

	@Override
	public List<CartItemDto> getAllCartItemById() throws Exception {
		
		return cartItemR.findAll().stream().map( a -> cartIMapper.toDto(a)).collect(Collectors.toList());
	}

}
