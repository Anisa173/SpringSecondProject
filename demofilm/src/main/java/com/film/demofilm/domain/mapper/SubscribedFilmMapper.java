package com.film.demofilm.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import com.film.demofilm.domain.dto.SubscribedFilmDto;

import com.film.demofilm.entity.SubscribedFilm;

public class SubscribedFilmMapper extends BaseMapper<SubscribedFilm, SubscribedFilmDto> {

	@Override
	public SubscribedFilm toEntity(SubscribedFilmDto subscrbFilmdto) {
		SubscribedFilm subscribedFilm = new SubscribedFilm();
		subscribedFilm.setId(subscrbFilmdto.getId());
		subscribedFilm.setReviews(subscrbFilmdto.getReviews());
		return subscribedFilm;
	}

	/*
	 * private Integer id; private Integer reviews; private Integer customerId;
	 * private String fullName; private Integer filmId; private String filmTitle;
	 * private BigDecimal onlineCost; private CartItem cartItem;
	 */
	@Override
	public SubscribedFilmDto toDto(SubscribedFilm entity) {
		SubscribedFilmDto filDto = new SubscribedFilmDto();
		filDto.setId(entity.getId());
		filDto.setReviews(entity.getReviews());
		filDto.setCustomerId(entity.getCustomer().getId());
		filDto.setFullName(entity.getCustomer().getFullName());
		filDto.setFilmId(entity.getFilm().getId());
		filDto.setFilmTitle(entity.getFilm().getFilmTitle());
		filDto.setOnlineCost(entity.getFilm().getOnlineCost());
		filDto.setCartItem(entity.getCartItem());
		return filDto;
	}

	@Override
	public SubscribedFilm toUpdate(SubscribedFilmDto dto, SubscribedFilm entity) {
		entity.setReviews(dto.getReviews());
		return entity;
	}

	@Override
	public List<SubscribedFilm> toEntity(List<SubscribedFilmDto> dtoList) {
		if (dtoList == null) {
			return null;
		}
		List<SubscribedFilm> subFilm = new ArrayList<SubscribedFilm>(dtoList.size());
		for (SubscribedFilmDto subFilmDto : dtoList) {
			subFilm.add(toEntity(subFilmDto));
		}

		return subFilm;
	}

	@Override
	public List<SubscribedFilmDto> toDto(List<SubscribedFilm> entityList) {
		if (entityList == null) {
			return null;
		}
		List<SubscribedFilmDto> subF = new ArrayList<SubscribedFilmDto>(entityList.size());
		for (SubscribedFilm film : entityList) {
			subF.add(toDto(film));
		}

		return subF;
	}

}
