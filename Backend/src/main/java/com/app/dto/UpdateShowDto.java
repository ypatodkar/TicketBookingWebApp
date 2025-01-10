package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.app.pojos.Screen;
import com.app.pojos.ShowStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateShowDto {
	private int showId;
	private LocalTime startTime;
	private LocalTime endTime;
	private int screenNumber;
	private ShowStatus showStatus;
	private int goldPrice;
	private int diamondPrice;
	private int silverPrice;
	private LocalDate showDate;
	
	@Override
	public String toString() {
		return "UpdateShowDto [showId=" + showId + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", screenNumber=" + screenNumber + ", showStatus=" + showStatus + ", goldPrice=" + goldPrice
				+ ", diamondPrice=" + diamondPrice + ", silverPrice=" + silverPrice + ", showDate=" + showDate + "]";
	}
	
	
	

	
}
