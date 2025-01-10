package com.app.service;

import java.util.List;

import com.app.pojos.Movie;

public interface IMovieService {
	Movie addMovie(Movie movie);
	List<Movie> getLatestMovies();
	Movie getMovie(String imdbId);
}
