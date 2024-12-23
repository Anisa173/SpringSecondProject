package com.film.demofilm.domain.mapper;

import java.util.List;

import com.film.demofilm.domain.dto.CartItemDto;

import com.film.demofilm.entity.CartItem;

public class CartItemMapper extends BaseMapper<CartItem, CartItemDto> {

	@Override
	public CartItem toEntity(CartItemDto dto) {
		CartItem cartI = new CartItem();
		cartI.setCiId(dto.getCiId());
		return cartI;
	}
	/*
	 * private Integer ciId; private Integer subscribeFilmId; private Integer
	 * filmId; private Integer customerId; private BigDecimal onlineCost; private
	 * String filmTittle; private Cart cart;
	 */

	@Override
	public CartItemDto toDto(CartItem entity) {
		CartItemDto cIdto = new CartItemDto();
		cIdto.setCiId(entity.getId());
		cIdto.setSubscribeFilmId(entity.getSubscriptionf().getId());
		cIdto.setFilmId(entity.getSubscriptionf().getFilm().getId());
		cIdto.setCustomerId(entity.getSubscriptionf().getCustomer().getId());
		cIdto.setOnlineCost(entity.getSubscriptionf().getFilm().getOnlineCost());
		cIdto.setFilmTittle(entity.getSubscriptionf().getFilm().getFilmTitle());
		cIdto.setCart(entity.getCart());
		return cIdto;
	}

	@Override
	public CartItem toUpdate(CartItemDto dto, CartItem entity) {

		return null;
	}

	@Override
	public List<CartItem> toEntity(List<CartItemDto> dtoList) {

		return null;
	}

	@Override
	public List<CartItemDto> toDto(List<CartItem> entityList) {

		return null;
	}

}
