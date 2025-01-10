package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Getter

@AllArgsConstructor
@NoArgsConstructor
public class UserBookingHistoryDto {
			private String movieName;
			private String poster;
			private LocalDate showDate;
			private LocalTime showStartTime;
			private LocalTime bookingTime;
			private LocalDate bookingDate;
			private int bookingId;
			private Double bookingAmount;
			private String theatreName;
			private String theatreCity;
			private int noOfSeats;
			private String paymentMode;
			private List<String> seatNos;
			
			public UserBookingHistoryDto(String movieName, String poster, LocalDate showDate, LocalTime showStartTime,
					LocalTime bookingTime, LocalDate bookingDate, int bookingId, Double bookingAmount,String theatreName,String theatreCity, int noOfSeats,
					String paymentMode) {
				super();
				this.movieName = movieName;
				this.poster = poster;
				this.showDate = showDate;
				this.showStartTime = showStartTime;
				this.bookingTime = bookingTime;
				this.bookingDate = bookingDate;
				this.bookingId = bookingId;
				this.bookingAmount = bookingAmount;
				this.theatreName = theatreName;
				this.theatreCity = theatreCity;
				this.noOfSeats = noOfSeats;
				this.paymentMode = paymentMode;
				this.seatNos = new ArrayList<String>();
			}
			
			public void setMovieName(String movieName) {
				this.movieName = movieName;
			}

			public void setPoster(String poster) {
				this.poster = poster;
			}

			public void setShowDate(LocalDate showDate) {
				this.showDate = showDate;
			}

			public void setShowStartTime(LocalTime showStartTime) {
				this.showStartTime = showStartTime;
			}

			public void setBookingTime(LocalTime bookingTime) {
				this.bookingTime = bookingTime;
			}

			public void setBookingDate(LocalDate bookingDate) {
				this.bookingDate = bookingDate;
			}

			public void setBookingId(int bookingId) {
				this.bookingId = bookingId;
			}

			public void setBookingAmount(Double bookingAmount) {
				this.bookingAmount = bookingAmount;
			}

			public void setNoOfSeats(int noOfSeats) {
				this.noOfSeats = noOfSeats;
			}

			public void setPaymentMode(String paymentMode) {
				this.paymentMode = paymentMode;
			}

			public void setSeatNos(String seatNumber) {
				this.seatNos.add(seatNumber);
			}

			public void setTheatreName(String theatreName) {
				this.theatreName = theatreName;
			}

			public void setTheatreCity(String theatreCity) {
				this.theatreCity = theatreCity;
			}

			
			
}
