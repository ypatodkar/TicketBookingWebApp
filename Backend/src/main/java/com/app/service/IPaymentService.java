package com.app.service;

import com.app.dto.BookAndPayDto;
import com.app.pojos.Booking;
import com.app.pojos.Payment;

public interface IPaymentService {
	Payment makePayment(BookAndPayDto paymentDetails, Booking booking);
}
