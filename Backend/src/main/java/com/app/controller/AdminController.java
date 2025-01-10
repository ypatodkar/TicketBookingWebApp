package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.TheatreAndOwnerDto;
import com.app.pojos.Screen;
import com.app.service.IScreenService;
import com.app.service.ITheatreService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins="http://localhost:3000")

public class AdminController {
		@Autowired
		private ITheatreService theatreService;

		
		@PostMapping("/addTheatre")
		@PreAuthorize("hasRole('ROLE_USER')")
		private ResponseEntity<?> addTheatre(@RequestBody @Valid TheatreAndOwnerDto theatreAndEmail ) {
			return new ResponseEntity<>(theatreService.addTheatre(theatreAndEmail.getTheatre(), theatreAndEmail.getEmail()), HttpStatus.OK);
		}
		
		@DeleteMapping("/removeTheatre/{id}")
		private ResponseEntity<?> removeTheatre(@PathVariable int id)  {
			System.out.println("reached inside endpoint");
			theatreService.deleteTheatre(id);
			return new ResponseEntity<>("Delete Successful", HttpStatus.OK);
		}
		
		@PostMapping("/theatre/{theatreId}/screen")
		private ResponseEntity<?> addScreen(@RequestBody @Valid Screen screen, @PathVariable int theatreId) {
			System.out.println("add screen");
			return new ResponseEntity<>(theatreService.addScreen(screen, theatreId), HttpStatus.OK);
		}
		
		@GetMapping("/getTheatres")
		private ResponseEntity<?> getAllTheatres(){
			return new ResponseEntity<>(theatreService.getAllTheatres(), HttpStatus.OK);
		}
		
		@GetMapping("/getTheatresByCity/{city}")
		private ResponseEntity<?> getAllTheatreCities(@PathVariable String city){
			return new ResponseEntity<>(theatreService.getAllTheatresByCity(city), HttpStatus.OK);
		}
	
		
		@PostMapping("/theatre/{theatreId}/addScreens")
		private ResponseEntity<?> addScreensByTheatre(@PathVariable int theatreId){
			theatreService.addAllScreens(theatreId);
			return new ResponseEntity<>("Added all screens successfully", HttpStatus.OK);
		}
}
