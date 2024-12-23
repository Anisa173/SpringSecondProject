package com.film.demofilm.domain.dto;

import java.math.BigDecimal;

import com.film.demofilm.entity.CartItem;

public class SubscribedFilmDto {
	private Integer id;
	private Integer reviews;
	private Integer customerId;
	private String fullName;
	private Integer filmId;
	private String filmTitle;
	private BigDecimal onlineCost;
	private CartItem cartItem;

	public SubscribedFilmDto() {
	}

	public SubscribedFilmDto(Integer id, Integer reviews, Integer customerId, String fullName, Integer filmId,
			String filmTitle, BigDecimal onlineCost, CartItem cartItem) {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReviews() {
		return reviews;
	}

	public void setReviews(Integer reviews) {
		this.reviews = reviews;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	public String getFilmTitle() {
		return filmTitle;
	}

	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}

	public BigDecimal getOnlineCost() {
		return onlineCost;
	}

	public void setOnlineCost(BigDecimal onlineCost) {
		this.onlineCost = onlineCost;
	}

	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}

	public String toString() {

		return "SubscribedFilmDto[id=" + id + ",reviews=" + reviews + ",customerId=" + customerId + ",fullName="
				+ fullName + ", filmId=" + filmId + ",filmTitle=" + filmTitle + ",onlineCost=" + onlineCost
				+ ", cartItem=" + cartItem + "]";
	}

	

}
