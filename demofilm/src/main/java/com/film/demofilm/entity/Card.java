package com.film.demofilm.entity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Card extends BaseEntity<Integer> {

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCustomer", referencedColumnName = "id")
	private User customer;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "number")
	private String number;
	@Column(name = "expDate")
	private Date expDate;
	@Column(name = "cvc")
	private String cvc;
	@Column(name = "cardHolderName")
	private String cardHolderName;

	public Card() {
		super();
	}

	public Card(String number, Date expDate, String cvc, String cardHolderName, User customer) {
		super();
		this.number = number;
		this.expDate = expDate;
		this.cvc = cvc;
		this.cardHolderName = cardHolderName;
		this.customer = customer;
	}

	@Override
	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public String toString() {
		return "Card[id=" + id + ",number=" + number + ",expDate=" + expDate + ",cvc=" + cvc + ",cardHolderName="
				+ cardHolderName + ", customer=" + customer + "]";
	}
}
