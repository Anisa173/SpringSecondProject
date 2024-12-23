package com.film.demofilm.service;

import java.math.BigDecimal;

import com.film.demofilm.domain.dto.CardDto;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface StripeServices {
	String createCustomer(String email, String token) throws StripeException;

	String addCardTopay(CardDto card, String email)
			throws StripeException;

	String makePaymentUsingCard(String paymentMethodId, String customerId, long amount) throws StripeException;

	String createCharge(String email, String token, int amount) throws StripeException;

	PaymentIntent createPaymentIntent(BigDecimal amount) throws StripeException;

	

}
