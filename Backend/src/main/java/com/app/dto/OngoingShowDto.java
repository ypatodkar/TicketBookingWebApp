package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.app.pojos.ShowStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OngoingShowDto {
	private Integer id;
	private LocalTime startTime;
	private LocalTime endTime;
	private LocalDate showDate;
	private String title;
	private String poster;
	private ShowStatus showStatus;
	
}
