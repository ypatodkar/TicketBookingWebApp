package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="booked_seats")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookedSeats extends BaseEntity {

	@Column(length = 40)
	private String seatNumber;
	@ManyToOne
	@JoinColumn(name = "show_id" , nullable=false)
	private Show show;
	@ManyToOne
	@JoinColumn(name = "booking_id", nullable=false)
	private Booking booking;
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private SeatStatus status;
	@Override
	public String toString() {
		return "BookedSeats [seatNumber=" + seatNumber + ", show=" + show + ", booking=" + booking + "]";
	}
	
	


	
	

}
