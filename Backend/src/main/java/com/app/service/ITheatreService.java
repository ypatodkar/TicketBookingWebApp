package com.app.service;

import java.util.List;

import com.app.dto.ScreenDto;
import com.app.dto.TheatreDto;
import com.app.pojos.Screen;
import com.app.pojos.Theatre;

public interface ITheatreService {
	Theatre addTheatre(Theatre theatre, String ownerEmail) ;
	void deleteTheatre(int id);
	Screen addScreen(Screen screen, int theatreId);
	List<TheatreDto> getAllTheatres();
	List<TheatreDto> getAllTheatresByCity(String city);
	List<ScreenDto> getAllScreens(int theatreId);
	void addAllScreens(int theatreId);
	TheatreDto getTheatreById(int theatreId);
	List<Theatre> getTheatreByUserId(int userId);
}
