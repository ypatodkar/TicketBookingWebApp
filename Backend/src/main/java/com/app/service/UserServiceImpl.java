package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.app.dao.AddressRepository;
import com.app.dao.UserRepository;
import com.app.dto.SeatNumberForHistoryDto;
import com.app.dto.UpdateUserDto;
import com.app.dto.UserBookingHistoryDto;
import com.app.pojos.Address;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private AddressRepository addressRepo;

	@Override
	public User registerUser(User user) {
		try {
			return userRepo.save(user);
		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException("Email Already Exists");
		}
	}

	@Override
	public User loginUser(User user) {

		return userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword())
				.orElseThrow(() -> new RuntimeException("User not valid"));
	}

	// -----------------------method for updating userDetails from profile
	// page----------------------------
	@Override
	public void updateUserDetails(String firstName, String lastName, String email, String phone, int userId) {
		// TODO Auto-generated method stub
		if (userRepo.existsById(userId)) {
			userRepo.updateUserDetails(firstName, lastName, email, phone, userId);
		} else
			throw new RuntimeException("Email Already exists");
	}

	// ----------------------method to update the user
	// address----------------------------------------------
	@Override
	public void updateUserAddress(String city, String state, String pincode, int userId) {
		// TODO Auto-generated method stub
		if(addressRepo.existsById(userId)) {
			addressRepo.updateUserAddress(city, state, pincode, userId);
		}else {
			User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
			addressRepo.save(new Address(city, state, pincode, user));
		}
	}

	@Override
	public List<UserBookingHistoryDto> getUserBookingHistory(int userId) {
		List<UserBookingHistoryDto> bookingHistory = userRepo.getUserBookingHistory(userId);
		List<SeatNumberForHistoryDto> seatsList = userRepo.getAllSeatsNos(userId);
		for (int i = 0; i < bookingHistory.size(); i++) {
			for (int j = 0; j < seatsList.size(); j++) {
				if(bookingHistory.get(i).getBookingId()==seatsList.get(j).getBookingId()) {
					bookingHistory.get(i).setSeatNos(seatsList.get(j).getSeatNumber());
				}
			}
		}		
		return bookingHistory;

	}

	
	//get the address of the user
	@Override
	public Address getAddressOfUser(int userId) {
		// TODO Auto-generated method stub
		return addressRepo.findByRegisterId(userId).orElseThrow(() -> new RuntimeException("User not found"));
	}

	//-----------------------------get user details for updating------------------------------------
	@Override
	public UpdateUserDto getUser(int userId) {
		// TODO Auto-generated method stub
		return userRepo.getUserDetails(userId);
	}

}
