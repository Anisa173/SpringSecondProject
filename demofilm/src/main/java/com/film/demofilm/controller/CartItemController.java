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
import com.film.demofilm.domain.dto.CartItemDto;
import com.film.demofilm.entity.CartItem;
import com.film.demofilm.service.CartItemService;

@RestController
@RequestMapping("/api/CartItem")
public class CartItemController {

	@Autowired
	private final CartItemService ciService;

	public CartItemController(CartItemService ciService) {
		this.ciService = ciService;
	}

	@PostMapping("add")
	public ResponseEntity<CartItem> addToCartItem(@RequestParam Integer id, @RequestParam Integer idFilm,
			@RequestBody CartItemDto cartItemDto) throws Exception {

		return ResponseEntity.ok(ciService.addToCartItem(cartItemDto, id, idFilm));
	}

	@GetMapping("/{ciId}")
	public ResponseEntity<CartItem> getCartItemById(@PathVariable Integer ciId) throws Exception {
		return ResponseEntity.ok(ciService.getCartItemById(ciId));
	}

	@GetMapping("all")
	public ResponseEntity<List<CartItemDto>> getAllCartItemById() throws Exception {

		return ResponseEntity.ok(ciService.getAllCartItemById());

	}
}