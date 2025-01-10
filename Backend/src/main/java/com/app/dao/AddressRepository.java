package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	@Modifying
	@Query(value="update user_address set city=?1, state=?2, pincode=?3 where user_id=?4", nativeQuery = true)
	void updateUserAddress(String city, String state, String pincode, int userId);
	
	//finder method to get address by user id
	Optional<Address> findByRegisterId(int userId);
	
}
