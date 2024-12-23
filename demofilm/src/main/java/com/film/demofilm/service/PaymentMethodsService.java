package com.film.demofilm.service;

import java.util.List;

import com.film.demofilm.domain.dto.PaymentMethodsDto;
import com.film.demofilm.entity.PaymentMethods;

import jakarta.validation.Valid;

public interface PaymentMethodsService {

	PaymentMethodsDto create(@Valid PaymentMethodsDto pmDto) throws Exception;

	void delete(Integer pmId) throws Exception;

	PaymentMethodsDto update(@Valid PaymentMethodsDto pmDto, Integer pmId) throws Exception;

	List<PaymentMethodsDto> getAllPaymentMethods() throws Exception;

	PaymentMethods getCartpaymentMethod(Integer pmId) throws Exception;

	PaymentMethods getApaymentMethod(Integer pmId) throws Exception;

	PaymentMethodsDto getPayMethodById(Integer pmId) throws Exception;

    PaymentMethodsDto getUserPaymentMethods(Integer id,Integer pmId) throws Exception;
	
}
