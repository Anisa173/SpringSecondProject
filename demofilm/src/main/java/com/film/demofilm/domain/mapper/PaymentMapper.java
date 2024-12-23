package com.film.demofilm.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import com.film.demofilm.domain.dto.PaymentDto;
import com.film.demofilm.entity.Payment;

public class PaymentMapper extends BaseMapper<Payment, PaymentDto> {

	@Override
	public Payment toEntity(PaymentDto dto) {
		Payment pay = new Payment();
		pay.setTokenId(dto.getTokenId());
		pay.setAmount(dto.getAmount());
		pay.setCurrency(dto.getCurrency());
		pay.setMetadata(dto.getMetadata());

		return pay;
	}
	

	@Override
	public PaymentDto toDto(Payment entity) {
		PaymentDto pay = new PaymentDto();
		pay.setTokenId(entity.getId());
		pay.setAmount(entity.getAmount());
		pay.setCurrency(entity.getCurrency());
		pay.setMetadata(entity.getMetadata());
		pay.setIdCart(entity.getCart().getId());
		

		return pay;
	}

	@Override
	public Payment toUpdate(PaymentDto dto, Payment entity) {
		
		return null;
	}

	@Override
	public List<Payment> toEntity(List<PaymentDto> dtoList) {
		
		return null;
	}

	@Override
	public List<PaymentDto> toDto(List<Payment> entityList) {
		if (entityList == null) {
			return null;
		}
		List<PaymentDto> pmdt = new ArrayList<PaymentDto>(entityList.size());
		for (Payment pay : entityList) {
			pmdt.add(toDto(pay));
		}
		return pmdt;
	}

}
