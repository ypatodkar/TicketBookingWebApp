package com.app.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CardRepository;
import com.app.dao.PaymentRepository;
import com.app.dao.UserRepository;
import com.app.dto.BookAndPayDto;
import com.app.pojos.Booking;
import com.app.pojos.Card;
import com.app.pojos.Payment;
import com.app.pojos.TransactionStatus;
import com.app.pojos.User;
@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService {
	@Autowired
	PaymentRepository paymentRepo;
	@Autowired
	IBookedSeatsService bookedSeatsService;
	@Autowired
	IBookingService bookingService;
	@Autowired
	ICardService cardService;
	@Autowired
	UserRepository userRepo;
	@Autowired
	CardRepository cardRepo;
	
	@Override
	public Payment makePayment(BookAndPayDto paymentDetails, Booking booking) {
		try {
			if (paymentDetails.getUpi()!=null) {
				return paymentRepo.save(new Payment(booking,"UPI",paymentDetails.getAmount(),LocalDateTime.now(),TransactionStatus.SUCCESS));
			}else {
				Payment payment=paymentRepo.save(new Payment(booking,"CARD",paymentDetails.getAmount(),LocalDateTime.now(),TransactionStatus.SUCCESS));
				User user = userRepo.findById(booking.getUser().getId()).orElseThrow(()->new RuntimeException("user does not exists"));
				System.out.println("reached Here");
				if (cardRepo.getCardDetails(paymentDetails.getUser().getId())==null) {
					cardService.setCardDetails(new Card(paymentDetails.getCardNumber(),paymentDetails.getExpiryDate(),paymentDetails.getCardHolderName(),user));
				}
				return payment;
			}
		
		}catch(RuntimeException e) {
			//In case of payment failed --> the booked seats and the booking needs to get cancelled
			bookingService.deleteBooking(booking.getId());
			bookedSeatsService.deleteBookedSeats(booking.getId());
			throw new RuntimeException("Payment Failed");
		}
		
	}

}
