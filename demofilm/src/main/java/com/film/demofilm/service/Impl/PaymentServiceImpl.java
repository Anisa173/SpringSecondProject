package com.film.demofilm.service.Impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.film.demofilm.domain.dto.CartDto;
import com.film.demofilm.domain.dto.PaymentDto;
import com.film.demofilm.domain.mapper.CartMapper;
import com.film.demofilm.domain.mapper.PaymentMapper;
import com.film.demofilm.repository.PaymentRepository;
import com.film.demofilm.service.CartService;
import com.film.demofilm.service.PaymentService;
import com.film.demofilm.service.StripeServices;
import com.stripe.model.PaymentIntent;

import jakarta.validation.Valid;

@Validated
@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private final CartService cService;
	@Autowired
	private final PaymentRepository pRepository;
	@Autowired
	private final PaymentMapper pMapper;
	@Autowired
	private final StripeServices stripeService;

	public PaymentServiceImpl(CartMapper cartMapper, CartService cService, PaymentRepository pRepository,
			PaymentMapper pMapper, StripeServices stripeService) {
		this.cartMapper = cartMapper;
		this.cService = cService;
		this.pRepository = pRepository;
		this.pMapper = pMapper;
		this.stripeService = stripeService;
	}

	@Override
	public PaymentDto addPreparedPayment(@Valid PaymentDto payDto, Integer id, Integer cartId, Integer pmId)
			throws Exception {
		var carta = cService.getCartByUserId(id, cartId, pmId);
		var pay = pMapper.toEntity(payDto);
		pay.setCart(carta);
		var result = pRepository.save(pay);
		return pMapper.toDto(result);
	}

	//checkout
	@Override
	public PaymentDto checkout(Integer id, Integer ciId, Integer cartId, Integer pmId) throws Exception {
		CartDto cartDto = cartMapper.toDto(cService.getCartByUserId(id, cartId, pmId));
		BigDecimal amountMoney = cartDto.getFilmCost();
		PaymentIntent payIntent = stripeService.createPaymentIntent(amountMoney);
		CartDto cartCreated = cService.preparePayment(cartDto, cartId, ciId, pmId);
		PaymentDto pay = new PaymentDto(payIntent.getClientSecret(), amountMoney, "usd", cartCreated.getCartId());
		var result = pMapper.toEntity(pay);
		return pMapper.toDto(pRepository.save(result));
	}



}
