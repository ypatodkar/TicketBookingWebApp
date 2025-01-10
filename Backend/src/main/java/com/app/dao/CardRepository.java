package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Card;

public interface CardRepository extends JpaRepository<Card, Integer>{
	//get card details of a user
	@Query("select c from Card c "
			+ "where c.user.id=:userId")
	Card getCardDetails(int userId);
	
	
}
