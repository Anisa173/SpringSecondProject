package com.film.demofilm.domain.mapper;

import java.util.ArrayList;
import java.util.List;
import com.film.demofilm.domain.dto.CartDto;
import com.film.demofilm.entity.Cart;

public class CartMapper extends BaseMapper<Cart, CartDto> {

	@Override
	public Cart toEntity(CartDto dto) {
		Cart cart = new Cart();
		cart.setCartId(dto.getCartId());
		return cart;
	}

	@Override
	public CartDto toDto(Cart entity) {
		CartDto cart = new CartDto();
		cart.setCartId(entity.getId());
		cart.setIdCartItem(entity.getCartItem().getId());
		cart.setFilmId(entity.getCartItem().getSubscriptionf().getFilm().getId());
		cart.setFilmCost(entity.getCartItem().getSubscriptionf().getFilm().getOnlineCost());
		cart.setCustomerId(entity.getCustomer().getId());
		cart.setFullName(entity.getCustomer().getFullName());
		var totalPaymMethods = entity.getPMethod().stream().count();
		cart.setTotalPaymMethods(totalPaymMethods);

		return cart;
	}

	@Override
	public Cart toUpdate(CartDto dto, Cart entity) {

		return null;
	}

	@Override
	public List<Cart> toEntity(List<CartDto> dtoList) {
		if (dtoList == null) {
			return null;
		}

		List<Cart> cart = new ArrayList<Cart>(dtoList.size());
		for (CartDto cartdt : dtoList) {
			cart.add(toEntity(cartdt));
		}
		return cart;
	}

	@Override
	public List<CartDto> toDto(List<Cart> entityList) {
		if (entityList == null) {
			return null;
		}

		List<CartDto> cartdto = new ArrayList<CartDto>(entityList.size());
		for (Cart cart : entityList) {
			cartdto.add(toDto(cart));
		}
		return cartdto;
	}

}
