package com.film.demofilm.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class CartItem extends BaseEntity<Integer> {
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subscribeFilmId", referencedColumnName = "id")
	private SubscribedFilm subscriptionf;

	@OneToOne(mappedBy = "cartItem", cascade = CascadeType.ALL)
	private Cart cart;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ciId;

	public CartItem() {
		super();
	}

	public CartItem(SubscribedFilm subscriptionf, Cart cart) {
		super();
		this.subscriptionf = subscriptionf;
		this.cart = cart;
	}

	@Override
	public Integer getId() {

		return ciId;
	}

	public void setCiId(Integer id) {
		this.ciId = id;
	}

	public SubscribedFilm getSubscriptionf() {
		return subscriptionf;
	}

	public void setSubscriptionf(SubscribedFilm subscriptionf) {
		this.subscriptionf = subscriptionf;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String toString() {
		return "CartItem[ciId=" + ciId + ",subscriptionf=" + subscriptionf + ",cart=" + cart + "]";
	}
}
