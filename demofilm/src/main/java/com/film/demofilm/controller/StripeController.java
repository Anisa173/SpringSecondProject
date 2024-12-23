package com.film.demofilm.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.film.demofilm.domain.dto.CardDto;
import com.film.demofilm.service.StripeServices;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

@RestController
@RequestMapping("/api/stripe")
public class StripeController {
	@Autowired
	private StripeServices stripeService;

	public StripeController(StripeServices stripeService) {
		this.stripeService = stripeService;
	}

	@PostMapping("/{token}")
	public ResponseEntity<String> createCustomer(@PathVariable String token, @RequestParam String email)
			throws StripeException {
		return ResponseEntity.ok(stripeService.createCustomer(token, email));
	}

	@PostMapping("/card")
	public ResponseEntity<String> addCartTopay(@RequestBody CardDto card, @RequestParam String email)
			throws StripeException {
		return ResponseEntity.ok(stripeService.addCardTopay(card, email));
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<String> makePaymentUsingCard(@PathVariable String customerId,
			@RequestParam String paymentMethodId, @RequestParam long amount) throws Exception {
		return ResponseEntity.ok(stripeService.makePaymentUsingCard(paymentMethodId, customerId, amount));
	}

	@PostMapping("{token}")
	public ResponseEntity<String> createCharge(@PathVariable String token, @RequestParam String email,
			@RequestParam int amount) throws StripeException {

		return ResponseEntity.ok(stripeService.createCharge(token, email, amount));
	}

	@PostMapping("/create-payment-intent")
	public ResponseEntity<PaymentIntent> createPaymentIntent(@RequestParam BigDecimal amount) throws StripeException {
		return ResponseEntity.ok(stripeService.createPaymentIntent(amount));
	}

}

//public String makePaymentUsingCard(String paymentMethodId, String customerId, long amount) throws StripeException
//String addCardTopay(String cardNumber, String expirationMonth, String expirationYear, String cvc, String email)
//throws StripeException;