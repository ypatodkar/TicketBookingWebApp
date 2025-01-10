package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="booking_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	@NotNull(message = "booking date cannot be null")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate bookingDate;
	@NotNull(message = "booking time cannot be null")
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime bookingTime;
	@NotNull(message = "amount cannot be null")
	private double amount;
	@ManyToOne
	@JoinColumn(name = "show_id", nullable = false)
	private Show show;
	@NotNull(message = "number of seats cannot be null")
	private int numberOfSeats;
	@Override
	public String toString() {
		return "Booking [user=" + user + ", bookingDate=" + bookingDate + ", bookingTime=" + bookingTime + ", amount="
				+ amount + ", show=" + show + ", numberOfSeats=" + numberOfSeats + "]";
	}


	
}
