package com.app.service;

import java.util.List;

import com.app.pojos.Booking;
import com.app.pojos.ReservedSeats;
import com.app.pojos.User;

public interface IBookingService {
	Booking createBooking(User user, double amount,List<ReservedSeats> seats);
	
	//In case of failed payment delete the booking
		int deleteBooking(int bookingId);
}
