package com.film.demofilm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.film.demofilm.domain.dto.PaymentDto;
import com.film.demofilm.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

	@Autowired
	private final PaymentService pService;

	public PaymentController(PaymentService pService) {
		this.pService = pService;
	}

	@PostMapping("/{id}/paymentMethods/cart/cartitem")
	public ResponseEntity<PaymentDto> addPreparedPayment(@RequestBody PaymentDto payDto, @PathVariable Integer id,
			@RequestParam Integer cartId, @RequestParam Integer pmId) throws Exception {
		return ResponseEntity.ok(pService.addPreparedPayment(payDto, id, cartId, pmId));
	}

	@PostMapping("/{cartId}")
	public ResponseEntity<PaymentDto> checkout(@RequestParam Integer id, @RequestParam Integer ciId,
			@PathVariable Integer cartId, @RequestParam Integer pmId, Authentication auth) throws Exception {
		return ResponseEntity.ok(pService.checkout(id, ciId, cartId, pmId));
	}

}

