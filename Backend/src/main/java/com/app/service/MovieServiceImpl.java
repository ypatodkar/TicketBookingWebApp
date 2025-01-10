package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.MovieRepository;
import com.app.pojos.Movie;

@Service
@Transactional
public class MovieServiceImpl implements IMovieService {

	@Autowired
	private MovieRepository movieRepo;
	
	@Override
	public Movie addMovie(Movie movie) {
		if(movieRepo.existsById(movie.getImdbId())) {
			Movie existingMovie = movieRepo.findById(movie.getImdbId()).get();
			existingMovie.setDateAdded(movie.getDateAdded());
			existingMovie.setRatings(movie.getRatings());
			return movieRepo.save(existingMovie);
		}
		return movieRepo.save(movie);
	}

	//getting the latest movies to show in the home page
	@Override
	public List<Movie> getLatestMovies() {
		// TODO Auto-generated method stub
		return movieRepo.findTop6ByOrderByDateAddedDesc();
	}

	@Override
	public Movie getMovie(String imdbId) {
		// TODO Auto-generated method stub
		return movieRepo.findById(imdbId).orElseThrow(() -> new RuntimeException("Movie not found! Sorry"));
	}
}
