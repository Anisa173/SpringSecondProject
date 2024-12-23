package com.film.demofilm.entity;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Payment extends BaseEntity<String>{

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idCart", referencedColumnName = "cartId")
	private Cart cart;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String tokenId;
	@Column(name = "amount")
	private BigDecimal amount;
	@Column(name = "currency")
	private String currency;
	@Column(name = "metadata")
	private Object metadata;

	public Payment() {
		super();
	}

	public Payment(BigDecimal amount, String currency, Object metadata, Cart cart) {
		super();
		this.amount = amount;
		this.currency = currency;
		this.metadata = metadata;
		this.cart = cart;
		
	}

	@Override
	public String getId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Object getMetadata() {
		return metadata;
	}

	public void setMetadata(Object metadata) {
		this.metadata = metadata;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	

	public String toString() {
		return "Payment[tokenId=" + tokenId + ",amount=" + amount + ",currency=" + currency + ",metadata=" + metadata
				+ ",cart=" + cart + ") ";
	}

}
