package com.film.demofilm.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cart extends BaseEntity<Integer> {

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "IdCartItem", referencedColumnName = "ciId")
	private CartItem cartItem;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", referencedColumnName = "id")
	private User customer;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<PaymentMethods> pMethod = new ArrayList<PaymentMethods>();

	@OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
	private Payment pay;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;

	public Cart() {
		super();
	}

	public Cart(CartItem cartItem, User customer, List<PaymentMethods> pMethod, Payment pay) {
		super();
		this.cartItem = cartItem;
		this.customer = customer;
		this.pMethod = pMethod;
		this.pay = pay;
	}

	@Override
	public Integer getId() {

		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public List<PaymentMethods> getPMethod() {
		return pMethod;
	}

	public void setPMethod(List<PaymentMethods> pMethod) {
		this.pMethod = pMethod;
	}

	public Payment getPay() {
		return pay;
	}

	public void setPay(Payment pay) {
		this.pay = pay;
	}

	public String toString() {
		return "Cart[cartId=" + cartId + ",cartItem=" + cartItem + ",customer=" + customer + ",pMethod=" + pMethod
				+ ",pay=" + pay + "]";
	}

}
