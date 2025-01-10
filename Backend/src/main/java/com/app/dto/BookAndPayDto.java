package com.app.dto;

import com.app.pojos.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class BookAndPayDto {
	private String upi;
	private User user;
	private double amount;
	private String cardHolderName;
	private String cardNumber;
	private String expiryDate;
	
	public BookAndPayDto(String upi, User user, double amount) {
		super();
		this.upi = upi;
		this.user = user;
		this.amount = amount;
	}

	public BookAndPayDto(User user, double amount, String cardHolderName, String cardNumber, String expiryDate) {
		super();
		this.user = user;
		this.amount = amount;
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
	}
	
	
}
