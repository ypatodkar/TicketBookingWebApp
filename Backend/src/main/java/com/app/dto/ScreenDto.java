package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScreenDto {
	private Integer id;
	private String screenStatus;
	private int screenNumber;
	private int theatre_id;
	
}
