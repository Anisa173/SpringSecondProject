package com.film.demofilm.domain.mapper;

import java.util.List;

import com.film.demofilm.domain.dto.CardDto;
import com.film.demofilm.entity.Card;

public class CardMapper extends BaseMapper<Card, CardDto> {

	@Override
	public Card toEntity(CardDto dto) {
		Card card = new Card();
		card.setId(dto.getId());
		card.setNumber(dto.getNumber());
		card.setExpDate(dto.getExpDate());
		card.setCvc(dto.getCvc());
		card.setCardHolderName(dto.getCardHolderName());
		return card;
	}

	@Override
	public CardDto toDto(Card dto) {
		CardDto card = new CardDto();
		card.setId(dto.getId());
		card.setNumber(dto.getNumber());
		card.setExpDate(dto.getExpDate());
		card.setCvc(dto.getCvc());
		card.setCardHolderName(dto.getCardHolderName());
		card.setIdCustomer(dto.getCustomer().getId());

		return card;
	}

	@Override
	public Card toUpdate(CardDto dto, Card entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Card> toEntity(List<CardDto> dtoList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CardDto> toDto(List<Card> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

}
