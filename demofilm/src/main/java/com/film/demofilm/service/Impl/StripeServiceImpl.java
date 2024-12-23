package com.film.demofilm.service.Impl;

import static com.stripe.Stripe.apiKey;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import com.stripe.param.ChargeCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.film.demofilm.domain.dto.CardDto;
import com.film.demofilm.domain.dto.PaymentDto;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentMethod;

import com.stripe.param.PaymentIntentCreateParams;

import jakarta.annotation.PostConstruct;

@Service
public class StripeServiceImpl {
	@Value("${stripe.secret-key}")

	private String API_SECET_KEY;

	private Stripe stripe;

	private String id;

	@PostConstruct
	public void init() {
		apiKey = API_SECET_KEY;
	}

	public StripeServiceImpl(String API_SECET_KEY, Stripe stripe) {
		this.API_SECET_KEY = API_SECET_KEY;
		this.stripe = stripe;
	}

	public String addCardTopay(CardDto card, String email) throws StripeException {

		Stripe.apiKey = API_SECET_KEY;

		Map<String, Object> cardParams = new HashMap<>();
		cardParams.put("number", card.number);
		cardParams.put("exp_month", card.expDate);
		cardParams.put("cardHolderName", card.cardHolderName);
		cardParams.put("cvc", card.cvc);

		Map<String, Object> paymentMethodParams = new HashMap<>();
		paymentMethodParams.put("type", "card");
		paymentMethodParams.put("card", cardParams);

		PaymentMethod paymentMethod = PaymentMethod.create(paymentMethodParams);

		Map<String, Object> customerParams = new HashMap<>();
		customerParams.put("email", email);
		customerParams.put("payment_method", paymentMethod.getId());

		Customer customer = Customer.create(customerParams);

		return customer.getId();

	}

	public String createCustomer(Customer customer , String token) throws StripeException {

		id = null;

		try {
			Stripe.apiKey = API_SECET_KEY;
			Map<String, Object> customerParams = new HashMap<>();
			customerParams.put("description", "Customer for " + customer.getEmail());
			customerParams.put("email", customer.getEmail());
			// obtained with stripe.js
			customerParams.put("source", token);

			Customer cust = Customer.create(customerParams);
		id = cust.getId();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer.getId();
	}

	public PaymentIntent makePaymentUsingCard(String paymentMethodId, String customerId, long amount) throws StripeException {
		Stripe.apiKey = API_SECET_KEY;

		Customer.retrieve(customerId);

		PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder().setAmount(amount)
				.setCurrency("usd").setPaymentMethod(paymentMethodId).setCustomer(customerId)
				.setConfirmationMethod(PaymentIntentCreateParams.ConfirmationMethod.AUTOMATIC).setConfirm(true).build();

		PaymentIntent paymentIntent = createPayment(createParams);
		return paymentIntent;

	}

	private PaymentIntent createPayment(PaymentIntentCreateParams params) throws StripeException {

		return PaymentIntent.create(params);

	}

	public String createCharge(String email, String token, int amount) throws StripeException {

		String chargeId = null;

		try {
			Stripe.apiKey = API_SECET_KEY;

			Map<String, Object> chargeParams = new HashMap<>();
			chargeParams.put("description", "Charge for " + email);
			chargeParams.put("currency", "usd");
			chargeParams.put("amount", amount);
			chargeParams.put("source", token);

			Charge charge = Charge.create(chargeParams);

			chargeId = charge.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chargeId;
	}

	public ChargeCreateParams toChargeParams(PaymentDto pay) {
		return new ChargeCreateParams.Builder().setAmount(pay.amount.multiply(new BigDecimal("100")).longValue())
				.setCurrency(pay.currency)
				.setDescription("Payment from Stripe checkout").setSource(pay.tokenId).build();
	}

	
	
	public PaymentIntent createPaymentIntent(BigDecimal amount) throws StripeException {
		Stripe.apiKey = API_SECET_KEY;
		Map<String, Object> params1 = new HashMap<>();
		params1.put("amount", amount.multiply(BigDecimal.valueOf(100)).intValue());
		params1.put("currency", "usd");
		params1.put("payment_method_types", Collections.singletonList("card"));
		return PaymentIntent.create(params1);
	}

}
