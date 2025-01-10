package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CardRepository;
import com.app.dao.UserRepository;
import com.app.dto.CardDto;
import com.app.pojos.Card;
import com.app.pojos.User;
@Service
@Transactional
public class CardServiceImpl implements ICardService {
	@Autowired
	CardRepository cardRepo;
	@Autowired
	UserRepository userRepo;
	
	@Override
	public Card getCardByUser(int userId) {
		try {
			Card card = cardRepo.getCardDetails(userId);
			if (card==null) {
				return new Card();
			}
			return card;
		}catch(RuntimeException e) {
			throw new RuntimeException("failing to fetch card details");
		}
	}

	@Override
	public Card setCardDetails(Card card) {
		try {
			return cardRepo.save(card);
		}catch(RuntimeException e) {
			throw  new RuntimeException("Card details are not saved");
		}
	
	}
	
	

}
