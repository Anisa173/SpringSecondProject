package com.film.demofilm.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import com.film.demofilm.domain.dto.PaymentMethodsDto;
import com.film.demofilm.entity.PaymentMethods;

public class PaymentMethodsMapper extends BaseMapper<PaymentMethods, PaymentMethodsDto> {

	@Override
	public PaymentMethods toEntity(PaymentMethodsDto dto) {
		PaymentMethods pm = new PaymentMethods();
		pm.setPmId(dto.getPmId());
		pm.setMethodAppName(dto.getMethodAppName());
		pm.setLogoAppUrl(dto.getLogoAppUrl());
		pm.setUrlApp(dto.getUrlApp());
		pm.setCurrency(dto.getCurrency());
		pm.setPmfeeCharged(dto.getPmfeeCharged());
		return pm;
	}
	/*
	 * private Integer pmId; private String methodAppName;
	 * 
	 * private String urlApp; private Integer idCart; private String filmTittle;
	 * private Integer chargeId; private BigDecimal pmfeeCharged; private String
	 * currency;
	 */

	@Override
	public PaymentMethodsDto toDto(PaymentMethods entity) {
		PaymentMethodsDto pmd = new PaymentMethodsDto();
		pmd.setPmId(entity.getId());
		pmd.setMethodAppName(entity.getMethodAppName());
		pmd.setLogoAppUrl(entity.getLogoAppUrl());
		pmd.setUrlApp(entity.getUrlApp());
		pmd.setIdCart(entity.getCart().getId());
		pmd.setFilmTittle(entity.getCart().getCartItem().getSubscriptionf().getFilm().getFilmTitle());
		pmd.setPmfeeCharged(entity.getPmfeeCharged());
		pmd.setCurrency(entity.getCurrency());
		pmd.setAdmId(entity.getAdmin().getId());
		return pmd;
	}

	@Override
	public PaymentMethods toUpdate(PaymentMethodsDto dto, PaymentMethods entity) {
		entity.setMethodAppName(dto.getMethodAppName());
		entity.setLogoAppUrl(dto.getLogoAppUrl());
		entity.setUrlApp(dto.getUrlApp());
		entity.setPmfeeCharged(dto.getPmfeeCharged());
		entity.setCurrency(dto.getCurrency());
		return entity;
	}

	@Override
	public List<PaymentMethods> toEntity(List<PaymentMethodsDto> dtoList) {
		if (dtoList == null) {
			return null;
		}
		List<PaymentMethods> pm = new ArrayList<PaymentMethods>(dtoList.size());
		for (PaymentMethodsDto pmd : dtoList) {
			pm.add(toEntity(pmd));
		}
		return pm;
	}

	@Override
	public List<PaymentMethodsDto> toDto(List<PaymentMethods> entityList) {

		return null;
	}

}
