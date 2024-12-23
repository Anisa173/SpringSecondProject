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
import jakarta.persistence.ManyToOne;

@Entity
public class PaymentMethods extends BaseEntity<Integer> {
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idCart", referencedColumnName = "cartId")
	private Cart cart;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "admId ", referencedColumnName = "id ")
	private User admin;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pmId;
	@Column(name = "methodAppName")
	private String methodAppName;
	@Column(name = "logoAppUrl")
	private String logoAppUrl;
	@Column(name = "urlApp")
	private String urlApp;
	@Column(name = "pmfeeCharged")
	private BigDecimal pmfeeCharged;
	@Column(name = "currency")
	private String currency;

	public PaymentMethods() {
		super();
	}

	public PaymentMethods(String methodApp, String logoAppUrl, String urlApp, String currency, BigDecimal pmfeeCharged,
			Cart cart, User admin) {
		super();
		this.methodAppName = methodApp;
		this.logoAppUrl = logoAppUrl;
		this.urlApp = urlApp;
		this.currency = currency;
		this.pmfeeCharged = pmfeeCharged;
		this.cart = cart;
		this.admin = admin;
	}

	@Override
	public Integer getId() {
		return pmId;
	}

	public void setPmId(Integer id) {
		this.pmId = id;
	}

	public String getMethodAppName() {
		return methodAppName;
	}

	public void setMethodAppName(String methodApp) {
		this.methodAppName = methodApp;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getUrlApp() {
		return urlApp;
	}

	public void setUrlApp(String urlApp) {
		this.urlApp = urlApp;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public BigDecimal getPmfeeCharged() {
		return pmfeeCharged;
	}

	public String getLogoAppUrl() {
		return logoAppUrl;
	}

	public void setLogoAppUrl(String logoAppUrl) {
		this.logoAppUrl = logoAppUrl;
	}

	public void setPmfeeCharged(BigDecimal pmfeeCharged) {
		this.pmfeeCharged = pmfeeCharged;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String toString() {
		return "PaymentMethods[pmId=" + pmId + ",logoAppUrl=" + logoAppUrl + ",methodApp=" + methodAppName + ",urlApp="
				+ urlApp + ",cart=" + cart + ",admin=" + admin + ",pmfeeCharged=" + pmfeeCharged + ",currency = "
				+ currency + "]";
	}

}
