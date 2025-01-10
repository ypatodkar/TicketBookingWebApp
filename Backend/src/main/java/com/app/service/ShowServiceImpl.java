package com.app.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.MovieRepository;
import com.app.dao.ScreenRepository;
import com.app.dao.ShowRepository;
import com.app.dao.TheatreRepository;
import com.app.dto.BookShowDto;
import com.app.dto.OngoingShowDto;
import com.app.dto.ShowTimeDto;
import com.app.dto.UpdateShowDto;
import com.app.pojos.Movie;
import com.app.pojos.Screen;
import com.app.pojos.Show;
import com.app.pojos.Theatre;

@Service
@Transactional
public class ShowServiceImpl implements IShowService {
	@Autowired
	ShowRepository showRepo;
	@Autowired
	ScreenRepository screenRepo;
	@Autowired
	TheatreRepository theatreRepo;
	@Autowired
	MovieRepository movieRepo;

	Logger LOGGER = LoggerFactory.getLogger(ShowServiceImpl.class);

	@Override
	public Show addShow(Show show, int screenId, int theatreId, String movieId) {
		// validation for adding show
		// 1.on the same screen show timing must not match
		// get all shows whose screen is same as (this) screen
		// find by id
		if (screenRepo.existsById(screenId) && theatreRepo.existsById(theatreId)) {
			Screen screen = screenRepo.findById(screenId).orElseThrow(() -> new RuntimeException("screen not found"));
			show.setScreen(screen);
			Theatre theatre = theatreRepo.findById(theatreId)
					.orElseThrow(() -> new RuntimeException("Theatre not found"));
			theatre.addScreen(screen);
			Movie movie = movieRepo.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
			show.setMovie(movie);
			// see if the timing are free on that screen
			List<Show> shows = showRepo.findByScreen(screen);
			// show time must not match with any show

			// show timings
			Iterator<Show> itr = shows.iterator();
			while (itr.hasNext()) {
				Show temp = (Show) itr.next();
				 if ((((show.getStartTime().isAfter(temp.getStartTime())) && (show.getStartTime().isBefore(temp.getEndTime())))
	                        || ((show.getEndTime().isAfter(temp.getStartTime())) && (show.getEndTime().isBefore(temp.getEndTime()))
	                                || (show.getStartTime().compareTo(temp.getStartTime())== 0 && show.getEndTime().compareTo(temp.getEndTime()) == 0)))
	                        && temp.getShowDate().isEqual(show.getShowDate())) {

	                    throw new RuntimeException("Show already exist at this timing");
	                }

			}
			return showRepo.save(show);
		} else {
			throw new RuntimeException("Show did not mount");
		}
		//
	}

	@Override
	public List<OngoingShowDto> getAllShows(int userId) {
		List<OngoingShowDto> shows = showRepo.getAllShows(userId);
		if (shows.isEmpty()) {
			throw new RuntimeException("There are no current ongoing shows to display");
		}
		return shows;
	}

	@Override
	public List<Show> getShowByCity(String city, String movieId) {
		List<Show> shows = showRepo.getShowsByCity(city, movieId);
		if (shows.isEmpty()) {
			throw new RuntimeException("No shows found");
		}

		return shows;
	}

	@Override
	public UpdateShowDto getShowbyId(int showId) {
		return showRepo.getShowById(showId);

	}

	public int updateShow(UpdateShowDto show) {
		System.out.println("reached here");
		System.out.println(show);
		int theatreId = showRepo.getTheatreIdByShowId(show.getShowId());
		System.out.println("Theatre Id "+theatreId);
		Integer screenId = showRepo.getScreenIdByScreenNumber(show.getScreenNumber(), theatreId);
		System.out.println("Screen Id "+screenId);
		return showRepo.updateShow(show.getDiamondPrice(), show.getEndTime(), show.getGoldPrice(),
				show.getShowStatus().toString(), show.getSilverPrice(), show.getStartTime(), show.getShowDate(),
				screenId, show.getShowId());
	}

	@Override
	public void deleteShow(int id) {
		if (showRepo.existsById(id)) {
			showRepo.deleteById(id);
		} else {
			throw new RuntimeException("Deletion of show failed");
		}
	}

	@Override
	public List<ShowTimeDto> getShowsByDate(LocalDate date, String city, String movieId) {

		return showRepo.getShowsByDate(date, city, movieId);

	}

	@Override
	public List<OngoingShowDto> getAllShowsByTheatre(int theatreId, LocalDate showDate) {
		List<OngoingShowDto> shows = showRepo.getAllShowsByTheatreByDate(theatreId, showDate);

		return shows;
	}

	@Override
	public BookShowDto getShowDetailsByShowId(int showId) {
		BookShowDto showDetails = showRepo.getShowDetailsByShowId(showId);

		if (showDetails == null) {
			throw new RuntimeException("No shows found");
		}

		return showDetails;
	}

	public String getImdbIdFromShowId(int showId) {
		String imdbId = showRepo.getImdbIdFromShowId(showId);
		if (imdbId == null) {
			throw new RuntimeException("Imdb Id not Found");
		}
		return imdbId;
	}

	// uupdating the show status using job scheduling
	@Override
	public void updateShowStatus(LocalTime endTime, LocalDate date) {
		// TODO Auto-generated method stub
		showRepo.updateStatus(endTime, date);
		LOGGER.info("Show Updated after " + endTime + " and " + date);
	}

	// updating the show status to running
	@Override
	public void updateShowToRunning(LocalTime timeNow, LocalDate date) {
		// TODO Auto-generated method stub
		showRepo.updateUpcomingToRunning(timeNow, date);
		LOGGER.info("Show Updated to RUNNING " + timeNow + " and " + date);
	}

	@Override
	public Integer getScreenIdByTheatreAndScreenNumber(int theatreId, int screenNumber) {
		return showRepo.getScreenIdByScreenNumber(theatreId, screenNumber);

	}

}
