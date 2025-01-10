package com.app.service;

import java.util.List;

import com.app.dto.UpdateUserDto;
import com.app.dto.UserBookingHistoryDto;
import com.app.pojos.Address;
import com.app.pojos.User;

public interface IUserService {
	User registerUser(User user);

	<Optional> User loginUser(User user);

	// updating user details
	void updateUserDetails(String firstName, String lastName, String email, String phone, int userId);

	// updating user address
	void updateUserAddress(String city, String state, String pincode, int userId);

	List<UserBookingHistoryDto> getUserBookingHistory(int userId);
	
	//get user address
	Address getAddressOfUser(int userId);
	
	//get all of user details
	UpdateUserDto getUser(int userId);
}
