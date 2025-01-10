package com.app.pojos;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reserved_seats", 
	uniqueConstraints = @UniqueConstraint(columnNames = {"show_id","seat_number"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservedSeats extends BaseEntity{
		@Column(name= "seat_number", length=40)
		private String seatNumber;
		@ManyToOne
		@JoinColumn(name = "show_id")
		private Show show;
		@ManyToOne
		@JoinColumn(name = "user_id")
		private User user;
		@Enumerated(EnumType.STRING)
		@Column(length=20)
		private SeatStatus status;
		private LocalTime sessionTime;
}
