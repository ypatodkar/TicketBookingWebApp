package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Movie;

public interface MovieRepository extends JpaRepository<Movie, String>{
	
	List<Movie> findTop6ByOrderByDateAddedDesc();
}
