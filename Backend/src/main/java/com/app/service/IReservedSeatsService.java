package com.app.service;

import java.time.LocalTime;
import java.util.List;

import com.app.pojos.ReservedSeats;

public interface IReservedSeatsService {
	List<String> getReservedSeats(int showId);
	List<ReservedSeats> reserveSeats(int showId,List<String> seats, int userId);
	
	List<ReservedSeats> getSeatsByUser(int userId);
	
	void deleteReservedSeatsofUser(int userId);
	//deleting reserved seats after the session expires
	void deleteReservedSeatsAfterSessionExpires(LocalTime timeNow);
}
