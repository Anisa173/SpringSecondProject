package com.film.demofilm.domain.dto;

import java.math.BigDecimal;

import com.stripe.param.ChargeCreateParams;

import lombok.Data;
@Data
public class PaymentDto {
	public String tokenId;
	public BigDecimal amount;
	public String currency;
	private Object metadata;
	private Integer idCart;
	

	public PaymentDto() {

		
	}
	
	public PaymentDto(String tokenId,BigDecimal amount,String currency,Object metadata) {
	this.tokenId=tokenId;
	this.amount=amount;	
		this.currency=currency;
	this.metadata=metadata;	
	this.idCart=idCart;
	
	}
	
	
	public String getTokenId() {
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

	public Integer getIdCart() {
		return idCart;
	}

	public void setIdCart(Integer idCart) {
		this.idCart = idCart;
	}

	
	

}
