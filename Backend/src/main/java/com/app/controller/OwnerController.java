package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UpdateShowDto;
import com.app.pojos.Movie;
import com.app.pojos.Show;
import com.app.service.IMovieService;
import com.app.service.IScreenService;
import com.app.service.IShowService;
import com.app.service.ITheatreService;

@RestController
@CrossOrigin(origins= "http://localhost:3000")
@RequestMapping("/api/owner")
public class OwnerController {
	
	@Autowired 
	IShowService showService;
	@Autowired
	IMovieService movieService;	
	@Autowired
	IScreenService screenService;
	@Autowired
	ITheatreService theatreService;
	
	@PostMapping("/theatre/{theatreId}/movie/{movieId}/screen/{screenId}/addShow")
	public ResponseEntity<?> addShow(@RequestBody Show show, @PathVariable int screenId, @PathVariable int theatreId, @PathVariable String movieId){
		return ResponseEntity.ok(showService.addShow(show,screenId,theatreId,movieId));
		
	}
	
	@GetMapping("/ongoingShow/{userId}")
	public ResponseEntity<?> ongoingShow(@PathVariable int userId){
		return ResponseEntity.ok(showService.getAllShows(userId));
	}
	
	@PostMapping("/updateScreen/{status}/{id}")
	public ResponseEntity<?> updateScreenStatuses(@PathVariable String status,@PathVariable int id){
		return new ResponseEntity<>(screenService.updateScreenStatus(status, id), HttpStatus.OK);
	}
	
	@PostMapping("/addMovie")
	public ResponseEntity<?> addMovie(@RequestBody Movie movie){
		return ResponseEntity.ok(movieService.addMovie(movie));
	}
	
	@GetMapping("/getShow/{showId}")
	public ResponseEntity<?> getShow(@PathVariable int showId){
		return ResponseEntity.ok(showService.getShowbyId(showId));
	}
	@PutMapping("/updateShow")
	public ResponseEntity<?> updateShow(@RequestBody UpdateShowDto show){
		return new ResponseEntity<>(showService.updateShow(show),HttpStatus.OK);
	}
	@DeleteMapping("/deleteShow/{id}")
	public ResponseEntity<?> deleteShow(@PathVariable int id){
		showService.deleteShow(id);
		return new ResponseEntity<>("Show Deleted Successfully",HttpStatus.OK);
	}
	@GetMapping("/getTheatreByUserId/{userId}")
	private ResponseEntity<?> getTheatreByUserId(@PathVariable int userId){
		return new ResponseEntity<>(theatreService.getTheatreByUserId(userId),HttpStatus.OK);
	}
	@GetMapping("/getNoOfScreens/{showId}")
	public ResponseEntity<?> getNoOfScreens(@PathVariable int showId){
		return ResponseEntity.ok(screenService.getScreenNumbersByShowId(showId));
	}
	
	@GetMapping("/getScreenNos/{theatreId}")
	private ResponseEntity<?> getAllScreenNos(@PathVariable int theatreId){
		return new ResponseEntity<>(theatreService.getAllScreens(theatreId), HttpStatus.OK);
	}
}
