package com.app.pojos;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movie_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	
	@NotNull(message = "Ratings cannot be empty")
	private double ratings;
	@NotBlank(message = "title cannot be empty")
	@Column(length = 50)
	private String title;
	@NotBlank(message = "Plot cannot be empty")
	private String plot;
	@NotBlank(message = "actors cannot be empty")
	@Column(length = 80)
	private String actors;
	@NotBlank(message = "director cannot be empty")
	@Column(length = 50)
	private String director;
	@NotBlank(message = "language cannot be empty")
	@Column(length = 50)
	private String language;
	@NotBlank(message = "Rated cannot be empty")
	@Column(length = 30)
	private String rated;
	@NotBlank(message = "poster cannot be empty")
	private String poster;
	@NotBlank(message = "duration cannot be empty")
	private String duration;
	@NotBlank(message = "backdrop path cannot be empty")
	private String backdropPath;
	@Id
	private String imdbId;
	@NotNull(message = "date added cannot be null")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateAdded;
	
	@Override
	public String toString() {
		return "Movie [ratings=" + ratings + ", title=" + title + ", plot=" + plot + ", actors=" + actors
				+ ", director=" + director + ", language=" + language + ", rated=" + rated + ", poster=" + poster
				+ ", duration=" + duration + ", imdbId=" + imdbId + "]";
	}

	
	
	
}
