package com.app.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.app.dto.BookShowDto;
import com.app.dto.OngoingShowDto;
import com.app.dto.ShowTimeDto;
import com.app.dto.UpdateShowDto;
import com.app.pojos.Show;

public interface IShowService {

	public Show addShow(Show show, int screenId, int theatreId, String movieId);

	// get all movies of particular user
	public List<OngoingShowDto> getAllShows(int userId);

	// to update a show details

	public UpdateShowDto getShowbyId(int showId);

	public int updateShow(UpdateShowDto show);

	public void deleteShow(int id);

	public List<Show> getShowByCity(String city, String movieId);

	public List<ShowTimeDto> getShowsByDate(LocalDate date, String city, String movieId);

	public List<OngoingShowDto> getAllShowsByTheatre(int theatreId, LocalDate showDate);

	public BookShowDto getShowDetailsByShowId(int showId);

	public String getImdbIdFromShowId(int showId);

	// to update the show which is running after the current time and date
	void updateShowStatus(LocalTime endTime, LocalDate date);

	// to update the show which ihas completed
	void updateShowToRunning(LocalTime timeNow, LocalDate date);

	public Integer getScreenIdByTheatreAndScreenNumber(int theatreId, int screenNumber);
}
