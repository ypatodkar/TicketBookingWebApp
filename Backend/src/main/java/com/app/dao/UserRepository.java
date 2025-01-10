package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.dto.SeatNumberForHistoryDto;
import com.app.dto.UpdateUserDto;
import com.app.dto.UserBookingHistoryDto;
import com.app.pojos.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmailAndPassword(String email, String password);

	Optional<User> findByEmail(String email);
	

	// letting the user update his profile
	@Modifying
	@Query("update User u set u.firstName=?1, u.lastName=?2, u.email=?3, u.phone=?4 where u.id=?5")
	void updateUserDetails(String firstName, String lastName, String email, String phone, int userId);

	
	@Query(value="select new com.app.dto.UserBookingHistoryDto(mv.title,mv.poster,sh.showDate,sh.startTime,b.bookingTime,b.bookingDate,b.id,b.amount,t.theatreName,t.theatreCity,b.numberOfSeats,p.paymentMode)"		+ " from Payment p"
			+ " join p.booking b"
			+ " join b.show sh"
			+ " join sh.screen sc"
			+ " join sc.theatre t"
			+ " join sh.movie mv"
			+ " where b.user.id= ?1")
	List<UserBookingHistoryDto> getUserBookingHistory(int userId);

	@Query(value = "select new com.app.dto.SeatNumberForHistoryDto(bs.seatNumber,bs.booking.id) from BookedSeats bs join bs.booking b join b.user u where u.id=?1")
	List<SeatNumberForHistoryDto> getAllSeatsNos(int userId, int bookingId);
	
	@Query(value="select new com.app.dto.SeatNumberForHistoryDto(bs.seatNumber,bs.booking.id) from BookedSeats bs join bs.booking b join b.user u where u.id=?1")
	List<SeatNumberForHistoryDto> getAllSeatsNos(int userId);
	//----------------query for getting user details for updating user profile
	@Query(value="select new com.app.dto.UpdateUserDto(u.email, u.firstName, u.lastName, u.phone) from User u where u.id=?1")
	UpdateUserDto getUserDetails(int userId);
}
