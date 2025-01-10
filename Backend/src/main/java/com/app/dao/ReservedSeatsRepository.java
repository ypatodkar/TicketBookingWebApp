package com.app.dao;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.ReservedSeats;

public interface ReservedSeatsRepository extends JpaRepository<ReservedSeats, Integer>{
	
	//get seats that are reserved from reservedSeats
		@Query("select r.seatNumber from ReservedSeats r where show.id=:showId")
		public List<String> getReservedSeats(@Param(value="showId") int showId);
		
	//get reserved seats by userId
		@Query("select r from ReservedSeats r where user.id=:userId")
		public List<ReservedSeats> getSeatsByUser(@Param(value="userId") int userId);
		
	//delete reserved seats of a user
		@Modifying
		@Query("delete from ReservedSeats r where user.id=:userId")
		public void deleteReservedSeats(@Param(value="userId") int userId);
		
		//removing the seats after session expires
		//deleting reserved seats which have crossed 15 mins mark
	//this is for scheduling a job clearing the reserved seats table
	@Modifying
	@Query("delete from ReservedSeats r where r.sessionTime <= :timeNow ")
	public void deleteReservedSeatsAfterSessionTime(@Param(value="timeNow") LocalTime timeNow);
}
