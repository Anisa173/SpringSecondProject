package com.film.demofilm.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.film.demofilm.configuration.SecurityUtils;
import com.film.demofilm.domain.dto.PaymentMethodsDto;
import com.film.demofilm.domain.exception.AppException;
import com.film.demofilm.domain.mapper.PaymentMethodsMapper;
import com.film.demofilm.entity.PaymentMethods;
import com.film.demofilm.entity.User;
import com.film.demofilm.repository.PaymentMethodsRepository;
import com.film.demofilm.service.PaymentMethodsService;
import com.film.demofilm.service.UserService;

import jakarta.validation.Valid;

@Validated
@Service
public class PaymentMethodServiceImpl implements PaymentMethodsService {
	@Autowired
	private final PaymentMethodsMapper pmMapper;
	@Autowired
	private final PaymentMethodsRepository pmRepo;
	@Autowired
	private final UserService uService;

	public PaymentMethodServiceImpl(PaymentMethodsMapper pmMapper, PaymentMethodsRepository pmRepo,
			UserService userService) {
		this.pmMapper = pmMapper;
		this.pmRepo = pmRepo;
		this.uService = userService;
	}

	@Override
	public PaymentMethodsDto create(@Valid PaymentMethodsDto pmDto) throws Exception {
		var a = pmMapper.toEntity(pmDto);
		var admId = SecurityUtils.getLoggedUserId();
		User ad = uService.findUserById(admId);
		a.setAdmin(ad);
		return pmMapper.toDto(pmRepo.save(a));
	}

	@Override
	public void delete(Integer pmId) throws Exception {
		pmRepo.deleteById(pmId);
	}

	@Override
	public List<PaymentMethodsDto> getAllPaymentMethods() throws Exception {
		return pmRepo.findAll().stream().map(a -> pmMapper.toDto(a)).collect(Collectors.toList());
	}

	@Override
	public PaymentMethods getApaymentMethod(Integer pmId) throws Exception {
		return pmRepo.findById(pmId)
				.orElseThrow(() -> new AppException("PaymentMethod not exist", HttpStatus.NOT_FOUND));
	}

	@Override
	public PaymentMethodsDto update(@Valid PaymentMethodsDto pmDto, Integer pmId) throws Exception {
		var pm = getApaymentMethod(pmId);
		var resultat = pmMapper.toUpdate(pmDto, pm);
		var admId = SecurityUtils.getLoggedUserId();
		User ad = uService.findUserById(admId);
		resultat.setAdmin(ad);
		var resultat1 = pmRepo.save(resultat);
		return pmMapper.toDto(resultat1);
	}

	@Override
	public PaymentMethods getCartpaymentMethod(Integer pmId) throws Exception {
		return pmRepo.getCartpaymentMethod(pmId);
	}

//Admini
	@Override
	public PaymentMethodsDto getPayMethodById(Integer pmId) throws Exception {
		return pmRepo.getPayMethodById(pmId);
	}

//Customer
	@Override
	public PaymentMethodsDto getUserPaymentMethods(Integer id, Integer pmId) throws Exception {
		return pmRepo.getUserPaymentMethods(id, pmId);
	}

}
