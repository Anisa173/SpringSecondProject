package com.film.demofilm.service;
import com.film.demofilm.domain.dto.PaymentDto;


import jakarta.validation.Valid;

public interface PaymentService {

PaymentDto addPreparedPayment(@Valid PaymentDto payDto, Integer id, Integer cartId, Integer pmId) throws Exception;

PaymentDto checkout(Integer id, Integer ciId, Integer cartId, Integer pmId) throws Exception ;

}
