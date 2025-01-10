package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowTimeDto {

	private String movieId;
	
	private int screenId;
	
	private int theatreId;
	
	private LocalDate showDate;
	
	private LocalTime startTime;
	
	private String theatreName;
	
	private int showId;
	
}
