package com.app.service;

import com.app.pojos.Card;

public interface ICardService {
	Card getCardByUser(int userId);
	
	//save the details of the card of a user
	Card setCardDetails(Card card);
}
