package com.app.service;

import java.util.List;

import com.app.pojos.Booking;
import com.app.pojos.User;

public interface IBookedSeatsService {
	List<String> getBookedSeats(int showId);
	
	//to move the reserved seats from reserved table to book table
	//==>to book the seats that are reserved by the user
	Booking bookSeats(User user,double amount);
	
	//In case of failed payment delete the booked seats
	String deleteBookedSeats(int bookingId);
	
	
}
