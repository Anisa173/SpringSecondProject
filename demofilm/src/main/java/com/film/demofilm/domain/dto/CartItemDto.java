package com.film.demofilm.domain.dto;

import java.math.BigDecimal;

import com.film.demofilm.entity.Cart;

public class CartItemDto {
	private Integer ciId;
	private Integer subscribeFilmId;
	private Integer filmId;
	private Integer customerId;
	private BigDecimal onlineCost;
	private String filmTittle;
	private Cart cart;

	public CartItemDto() {
	}

	public CartItemDto(Integer ciId, Integer subscribeFilmId, Integer filmId, Integer customerId, BigDecimal onlineCost,
			String filmTittle, Cart cart) {
		this.ciId = ciId;
		this.subscribeFilmId = subscribeFilmId;
		this.filmId = filmId;
		this.customerId = customerId;
		this.onlineCost = onlineCost;
		this.filmTittle = filmTittle;
		this.cart = cart;
	}

	public Integer getCiId() {
		return ciId;
	}

	public void setCiId(Integer ciId) {
		this.ciId = ciId;
	}

	public Integer getSubscribeFilmId() {
		return subscribeFilmId;
	}

	public void setSubscribeFilmId(Integer subscribeFilmId) {
		this.subscribeFilmId = subscribeFilmId;
	}

	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getOnlineCost() {
		return onlineCost;
	}

	public void setOnlineCost(BigDecimal onlineCost) {
		this.onlineCost = onlineCost;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getFilmTittle() {
		return filmTittle;
	}

	public void setFilmTittle(String filmTittle) {
		this.filmTittle = filmTittle;
	}

	public String toString() {
		return "CartItemDto[ciId=" + ciId + ",subscribeFilmId=" + subscribeFilmId + ", filmId=" + filmId
				+ ", customerId=" + customerId + ", onlineCost=" + onlineCost + ",filmTittle=" + filmTittle + ", cart="
				+ cart + ",]";
	}

}
