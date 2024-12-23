package com.film.demofilm.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class SubscribedFilm extends BaseEntity<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "reviews")
	private Integer reviews;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId", referencedColumnName = "id")
	private User customer;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "filmId", referencedColumnName = "idFilm")
	private Films film;

	@OneToOne(mappedBy = "subscriptionf", cascade = CascadeType.ALL)
	private CartItem cartItem;

	public SubscribedFilm() {
		super();
	}

	public SubscribedFilm(Integer reviews, User customer, Films film) {
		super();
		this.reviews = reviews;
		this.customer = customer;
		this.film = film;

	}

	@Override
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

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Films getFilm() {
		return film;
	}

	public void setFilm(Films fil) {
		this.film = fil;
	}

	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem ci) {
		this.cartItem = ci;
	}

	public String toString() {
		return "SubscribedFilm[id=" + id + ",reviews=" + reviews + ",customer=" + customer + ",film=" + film
				+ ",cartItem=" + cartItem + "]";
	}
}
