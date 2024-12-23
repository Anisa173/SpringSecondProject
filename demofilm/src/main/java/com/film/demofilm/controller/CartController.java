package com.film.demofilm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.film.demofilm.domain.dto.CartDto;
import com.film.demofilm.entity.Cart;
import com.film.demofilm.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	private final CartService cartService;

	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@PostMapping("/{id}/cartItem/paymentMethods")
	public ResponseEntity<CartDto> preparePayment(@PathVariable Integer id, @RequestBody CartDto cDto,
			@RequestParam Integer ciId, @RequestParam Integer pmId) throws Exception {
		return ResponseEntity.ok(cartService.preparePayment(cDto, id, ciId, pmId));

	}

	@GetMapping("/{cartId}/user/cartitem/paymentMethods")
	public ResponseEntity<Cart> getCartByUserId(@PathVariable Integer cartId, @RequestParam Integer id,
			@RequestParam Integer ciId, @RequestParam Integer pmId) throws Exception {

		return ResponseEntity.ok(cartService.getCartByUserId(id, cartId, pmId));
	}

	@GetMapping("all")
	public ResponseEntity<List<CartDto>> getAllCarts() throws Exception {
		return ResponseEntity.ok(cartService.getAllCarts());
	}

}