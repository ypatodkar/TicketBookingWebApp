package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookShowDto {
	
	private int showId;
	private String theatreName;
	private String theatreCity;
	private String title;
	private int screenNumber;
	private LocalTime startTime;
	private String language;
	private String rated;
	private LocalDate date;
	private int goldPrice;
	private int diamondPrice;
	private int silverPrice;
	
}
