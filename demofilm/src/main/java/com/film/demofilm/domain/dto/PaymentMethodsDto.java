package com.film.demofilm.domain.dto;

import java.math.BigDecimal;

public class PaymentMethodsDto {
	private Integer pmId;
	private String methodAppName;
	private String logoAppUrl;
	private String urlApp;
	private Integer idCart;
	private String filmTittle;
	private BigDecimal pmfeeCharged;
	private String currency;
	private Integer admId;

	public PaymentMethodsDto() {
	}

	public PaymentMethodsDto(Integer pmId, String methodApp, String logoAppUrl, String url, Integer idCart,
			String filmTittle, BigDecimal pmfeeCharged, String currency, Integer admId) {
		this.pmId = pmId;
		this.methodAppName = methodApp;
		this.logoAppUrl = logoAppUrl;
		this.urlApp = url;
		this.idCart = idCart;
		this.filmTittle = filmTittle;
		this.pmfeeCharged = pmfeeCharged;
		this.currency = currency;
		this.admId = admId;
	}

	public Integer getPmId() {
		return pmId;
	}

	public void setPmId(Integer pmId) {
		this.pmId = pmId;
	}

	public String getMethodAppName() {
		return methodAppName;
	}

	public void setMethodAppName(String methodApp) {
		this.methodAppName = methodApp;
	}

	public String getUrlApp() {
		return urlApp;
	}

	public void setUrlApp(String urlApp) {
		this.urlApp = urlApp;
	}

	public Integer getIdCart() {
		return idCart;
	}

	public void setIdCart(Integer idCart) {
		this.idCart = idCart;
	}

	public String getFilmTittle() {
		return filmTittle;
	}

	public void setFilmTittle(String filmTittle) {
		this.filmTittle = filmTittle;
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

	public Integer getAdmId() {
		return admId;
	}

	public void setAdmId(Integer admId) {
		this.admId = admId;
	}

	public String toString() {
		return "PaymentMethodsDto[pmId=" + pmId + ",methodAppName=" + methodAppName + ",logoAppUrl=" + logoAppUrl
				+ ",urlApp=" + urlApp + ",idCart=" + idCart + ",filmTittle=" + filmTittle + ",pmfeeCharged="
				+ pmfeeCharged + ",currency=" + currency + "]";
	}

}
