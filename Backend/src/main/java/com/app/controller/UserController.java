package com.app.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BookAndPayDto;
import com.app.dto.UpdateUserDto;
import com.app.pojos.Address;
import com.app.pojos.Booking;
import com.app.service.IBookedSeatsService;
import com.app.service.ICardService;
import com.app.service.IMovieService;
import com.app.service.IPaymentService;
import com.app.service.IReservedSeatsService;
import com.app.service.IShowService;
import com.app.service.ITheatreService;
import com.app.service.IUserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private IMovieService movieService;
	@Autowired
	private IShowService showService;
	@Autowired
	private ITheatreService theatreService;
	@Autowired
	private IBookedSeatsService bookSeatsService;
	@Autowired
	private IReservedSeatsService reservedSeatsService;
	@Autowired
	private IPaymentService payService;
	@Autowired
	private IUserService userService;
	@Autowired
	private ICardService cardService;

	@GetMapping("/nowShowing")
	public ResponseEntity<?> getNowShowing() {
		return new ResponseEntity<>(movieService.getLatestMovies(), HttpStatus.OK);
	}

	@GetMapping("/getMovie/{imdbId}")
	public ResponseEntity<?> getMovie(@PathVariable String imdbId) {
		return new ResponseEntity<>(movieService.getMovie(imdbId), HttpStatus.OK);
	}

	@GetMapping("/getShowsByCity/{city}/{movieId}")
	public ResponseEntity<?> getShowsByCity(@PathVariable String city, @PathVariable String movieId) {
		System.out.println("In Get Mapping");
		return new ResponseEntity<>(showService.getShowByCity(city, movieId), HttpStatus.OK);
	}

	@GetMapping("/location/{location}/movie/{movieId}/getShowsByDate/{date}")
	public ResponseEntity<?> getShowsByDate(@PathVariable String location, @PathVariable String movieId,
			@PathVariable String date) {
		return new ResponseEntity<>(showService.getShowsByDate(
				LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")), location, movieId), HttpStatus.OK);
	}

	@GetMapping("/theatre/{theatreId}/date/{date}")
	public ResponseEntity<?> getAllShowsByTheatre(@PathVariable int theatreId, @PathVariable String date) {
		return new ResponseEntity<>(showService.getAllShowsByTheatre(theatreId,
				LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"))), HttpStatus.OK);
	}

	@GetMapping("/theatre/{theatreId}")
	public ResponseEntity<?> getTheatreDetailsById(@PathVariable int theatreId) {
		return new ResponseEntity<>(theatreService.getTheatreById(theatreId), HttpStatus.OK);
	}

	@GetMapping("/getBookedSeats/{showId}")
	public ResponseEntity<?> getBookedSeats(@PathVariable int showId) {
		return new ResponseEntity<>(bookSeatsService.getBookedSeats(showId), HttpStatus.OK);
	}

	@GetMapping("/booking/ticket/{showId}")
	public ResponseEntity<?> getBookingTicketDetails(@PathVariable int showId) {
		return new ResponseEntity<>(showService.getShowDetailsByShowId(showId), HttpStatus.OK);
	}

	@GetMapping("/imdbId/{showId}")
	public ResponseEntity<?> getImdbIdFromShowID(@PathVariable int showId) {
		return new ResponseEntity<>(showService.getImdbIdFromShowId(showId), HttpStatus.OK);
	}

	@PostMapping("/{userId}/reservedSeats/{showId}")
	public ResponseEntity<?> getReservedSeats(@RequestBody List<String> checkedSeats, @PathVariable int userId,
			@PathVariable int showId) {
		return new ResponseEntity<>(reservedSeatsService.reserveSeats(showId, checkedSeats, userId), HttpStatus.OK);
	}

	@DeleteMapping("/{userId}/deleteReservedSeats")
	public ResponseEntity<?> deleteReserveSeats(@PathVariable int userId) {
		reservedSeatsService.deleteReservedSeatsofUser(userId);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/bookAndPay")
	public ResponseEntity<?> bookAndPay(@RequestBody BookAndPayDto bookAndPay) {
		System.out.println("hum aa gaye");
		Booking booking = bookSeatsService.bookSeats(bookAndPay.getUser(), bookAndPay.getAmount());
		System.out.println(booking);
		return new ResponseEntity<>(payService.makePayment(bookAndPay, booking), HttpStatus.OK);
	}

	@PostMapping("/{userId}/update")
	public ResponseEntity<?> updateUser(@RequestBody UpdateUserDto updateUser, @PathVariable int userId) {
		userService.updateUserDetails(updateUser.getFirstName(), updateUser.getLastName(), updateUser.getEmail(),
				updateUser.getPhone(), userId);
		return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
	}

	@PostMapping("/{userId}/address")
	public ResponseEntity<?> updateUserAddress(@RequestBody Address address, @PathVariable int userId) {
		userService.updateUserAddress(address.getCity(), address.getState(), address.getPincode(), userId);
		return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
	}

	@GetMapping("/getUserBookingHistory/{userId}")
	public ResponseEntity<?> getUserBookingHistory(@PathVariable int userId) {
		return new ResponseEntity<>(userService.getUserBookingHistory(userId), HttpStatus.OK);
	}

	@GetMapping("/{userId}/address")
	public ResponseEntity<?> getAddress(@PathVariable int userId) {
		return new ResponseEntity<>(userService.getAddressOfUser(userId), HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<?> getUser(@PathVariable int userId){
		return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
	}
	
	@GetMapping("/getCardDetails/{userId}")
	public ResponseEntity<?> getCardDetails(@PathVariable int userId) {
		System.out.println("UserId : "+userId);
		return new ResponseEntity<>(cardService.getCardByUser(userId), HttpStatus.OK);
	}
}
