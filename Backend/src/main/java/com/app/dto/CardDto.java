package com.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {

	@Column(name = "card_number", length = 16)
	@NotBlank(message = "card number is mandatory")
	private String cardNumber;
	@Column(name = "card_expiry", length = 6)
	@NotBlank(message = "card expiry date is mandatory")
	private String cardExpiryDate;
	@Column(name = "card_holder_name", length = 50)
	@NotBlank(message = "card expiry date is mandatory")
	private String cardHolderName;
}
