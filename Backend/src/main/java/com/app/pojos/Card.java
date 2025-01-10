package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="card_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card extends BaseEntity{

    @Column(name="card_number", length = 16)
    @NotBlank(message = "card number is mandatory")
    private String cardNumber;
    @Column(name="card_expiry", length = 6)
    @NotBlank(message = "card expiry date is mandatory")
    private String cardExpiryDate;
    @Column(name="card_holder_name", length = 50)
    @NotBlank(message = "card expiry date is mandatory")
    private String cardHolderName;
    
    @Override
	public String toString() {
		return "Card [cardNumber=" + cardNumber + ", cardExpiryDate=" + cardExpiryDate + ", cardHolderName="
				+ cardHolderName + ", user=" + user + "]";
	}
	@OneToOne
    @JoinColumn(name="user_id",nullable=false)
    User user;




}
