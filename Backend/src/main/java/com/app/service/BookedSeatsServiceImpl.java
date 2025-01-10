package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BookedSeatRepository;
import com.app.dao.BookingRepository;
import com.app.dao.ReservedSeatsRepository;
import com.app.pojos.BookedSeats;
import com.app.pojos.Booking;
import com.app.pojos.ReservedSeats;
import com.app.pojos.SeatStatus;
import com.app.pojos.User;

@Service
@Transactional
public class BookedSeatsServiceImpl implements IBookedSeatsService{
	@Autowired 
	BookedSeatRepository bookSeatsRepo;
	@Autowired
	ReservedSeatsRepository reserveRepo;
	@Autowired
	IBookingService bookingService;
	
	@Override
	public List<String> getBookedSeats(int showId) {
		try {
			List<String> seats = bookSeatsRepo.getBookedSeats(showId);
			List<String> reserved = reserveRepo.getReservedSeats(showId);
			if (!reserved.isEmpty()) {
				seats.addAll(reserved);
			}
			return seats;
		}catch(RuntimeException e) {
			throw new RuntimeException("Could not retrive booked seats");
		}
	}

	//to book the tickets
	@Override
	public Booking bookSeats(User user, double amount) {
		try {
			List<ReservedSeats> seats = reserveRepo.getSeatsByUser(user.getId());
			if (seats.size()==0) {
				System.out.println("Inside if statement of BookedSeats");
				throw new RuntimeException("Sorry, your session has expired");
			}
			Booking booking = bookingService.createBooking(user, amount,seats);
			System.out.println("Booking inside bsService "+booking);
			seats.forEach((s)->bookSeatsRepo.save(new BookedSeats(s.getSeatNumber(),s.getShow(),booking,SeatStatus.BOOKED)));
			reserveRepo.deleteReservedSeats(user.getId());
			return booking;
		}catch(RuntimeException e) {
			throw new RuntimeException("Booking failed");
		}
	}

	@Override
	public String deleteBookedSeats(int bookingId) {
		try {
			bookSeatsRepo.deleteBookedSeats(bookingId);
		}catch(RuntimeException e) {
			throw new RuntimeException("booked seats did not get cancelled");
		}
		return null;
	}

	
	
}
