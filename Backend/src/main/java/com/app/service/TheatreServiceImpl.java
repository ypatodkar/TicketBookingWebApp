package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ScreenRepository;
import com.app.dao.TheatreRepository;
import com.app.dao.UserRepository;
import com.app.dto.ScreenDto;
import com.app.dto.TheatreDto;
import com.app.exception.AdminSqlExcep;
import com.app.pojos.Screen;
import com.app.pojos.Theatre;
import com.app.pojos.User;

@Service
@Transactional
public class TheatreServiceImpl implements ITheatreService {
	@Autowired
	private TheatreRepository theatreRepo;
	@Autowired
	private ScreenRepository screenRepo;
	@Autowired
	private UserRepository userRepo;

	
	
	@Override
	public Theatre addTheatre(Theatre theatre, String ownerEmail) {
		User owner = userRepo.findByEmail(ownerEmail).orElseThrow(() -> new RuntimeException("Owner does not exist"));
		theatre.setUser(owner);
		return theatreRepo.save(theatre);
	}

	@Override
	public void deleteTheatre(int id)  {
		if(theatreRepo.existsById(id))
			theatreRepo.setTheatreInActive(id);
		else
			throw new AdminSqlExcep("Theatre deletion failed, no theatre present with ID: " + id);
	}

	@Override
	public Screen addScreen(Screen screen, int theatreId) {
		if(theatreRepo.existsById(theatreId)) {
			screen.setTheatre(theatreRepo.findById(theatreId).orElseThrow(() -> new AdminSqlExcep("theatre not found")));  
			return screenRepo.save(screen);
		}
		throw new AdminSqlExcep("adding screens has failed");
	}


	
	@Override
	public List<TheatreDto> getAllTheatres(){
		return theatreRepo.findAllTheatres();
	}

	@Override
	public List<TheatreDto> getAllTheatresByCity(String city) {
		return theatreRepo.findAllTheatresByCity(city);
	}

	
	
	@Override
	public List<ScreenDto> getAllScreens(int theatreId) {
		return theatreRepo.getAllScreenNumbers(theatreId);
	}

	@Override
	public void addAllScreens(int theatreId) {
		// TODO Auto-generated method stub
		Theatre theatre = theatreRepo.findById(theatreId).orElseThrow(() -> new RuntimeException("Theatre with theatre id: " + theatreId + "doesn't exist"));
		for(int i = 1; i <= theatre.getNumberOfScreens(); i++) {
			Screen screen = new Screen(i, theatre, "ACTIVE");
			screenRepo.save(screen);
		}
	}

	@Override
	public TheatreDto getTheatreById(int theatreId) {
		
		return theatreRepo.getMyTheatreById(theatreId);
	}
	
	
	public List<Theatre> getTheatreByUserId(int userId){
		return theatreRepo.getTheatreByUserId(userId);
	}
	
	

}
