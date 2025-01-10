package com.app.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BookingRepository;
import com.app.pojos.Booking;
import com.app.pojos.ReservedSeats;
import com.app.pojos.User;
@Service
@Transactional
public class BookingServiceImpl implements IBookingService {
	@Autowired
	BookingRepository bookingRepo;
	
	
	@Override
	public Booking createBooking(User user,double amount, List<ReservedSeats> seats) {
		return bookingRepo.save(new Booking(user,LocalDate.now(),LocalTime.now(),amount,seats.get(0).getShow(),seats.size()));
		
	}
	
	@Override
	public int deleteBooking(int bookingId) {
		try {
			if (bookingRepo.existsById(bookingId)) {
				bookingRepo.deleteById(bookingId);
			}
			return bookingId;
		}catch(RuntimeException e) {
			throw new RuntimeException("Booking does not exists");
		}
	}

}
