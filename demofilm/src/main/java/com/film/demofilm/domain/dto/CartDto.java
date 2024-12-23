package com.film.demofilm.domain.dto;

import java.math.BigDecimal;

import com.film.demofilm.entity.Payment;

public class CartDto {
	private Integer cartId;
	private Integer IdCartItem;
	private Integer customerId;
	private String fullName;
	private Long totalPaymMethods;
	private Payment pay;
	private Integer filmId;
	private BigDecimal filmCost;

	public CartDto() {
	}

	public CartDto(Integer cartId, Integer IdCartItem, String customerFullName, Integer customerId, Integer filmId,
			BigDecimal onlineCost, Long totalPMethod, Payment pay) {
		this.cartId = cartId;
		this.IdCartItem = IdCartItem;
		this.customerId = customerId;
		this.fullName = customerFullName;
		this.filmId = filmId;
		this.filmCost = onlineCost;
		this.totalPaymMethods = totalPMethod;
		this.pay = pay;

	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getIdCartItem() {
		return IdCartItem;
	}

	public void setIdCartItem(Integer idCartItem) {
		IdCartItem = idCartItem;
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

	public BigDecimal getFilmCost() {
		return filmCost;
	}

	public void setFilmCost(BigDecimal onlineCost) {
		this.filmCost = onlineCost;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getTotalPaymMethods() {
		return totalPaymMethods;
	}

	public void setTotalPaymMethods(Long totalPaymMethods2) {
		this.totalPaymMethods = totalPaymMethods2;
	}

	public Payment getPay() {
		return pay;
	}

	public void setPay(Payment pay) {
		this.pay = pay;
	}

	public String toString() {
		return "CartDto[cartId=" + cartId + ",IdCartItem=" + IdCartItem + ",fullName=" + fullName + ", filmId="
				+ IdCartItem + ",customerId=" + customerId + ",filmCost=" + filmCost + ",totalPaymMethods="
				+ totalPaymMethods + ", pay=" + pay + "]";
	}

}
