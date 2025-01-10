package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment_details")
@Getter
@Setter
@NoArgsConstructor
public class Payment extends BaseEntity{

	@ManyToOne
	@JoinColumn(name = "booking_id", nullable = false)
	private Booking booking;
	@Column(length = 30)
	private String paymentMode;
	private double amount;
	private LocalDateTime dateAndTime;
	@Enumerated(EnumType.STRING)
	private TransactionStatus transactionStatus;


	public Payment(Booking booking, String paymentMode, double amount, LocalDateTime dateAndTime,
			TransactionStatus transactionStatus) {
		super();
		this.booking = booking;
		this.paymentMode = paymentMode;
		this.amount = amount;
		this.dateAndTime = dateAndTime;
		this.transactionStatus = transactionStatus;
	}
	
	
}

