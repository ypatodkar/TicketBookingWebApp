package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheatreDto {
	
	
	private Integer id;
	private String theatreName;
	private String theatreState;
	private String theatreCity;
	private String pincode;
	public TheatreDto(Integer id, String theatreName, String theatreState, String theatreCity, String pincode) {
		super();
		this.id = id;
		this.theatreName = theatreName;
		this.theatreState = theatreState;
		this.theatreCity = theatreCity;
		this.pincode = pincode;
	}
	public TheatreDto(Integer id, String theatreName, String theatreState, String theatreCity) {
		super();
		this.id = id;
		this.theatreName = theatreName;
		this.theatreState = theatreState;
		this.theatreCity = theatreCity;
	}
	public TheatreDto(Integer id, String theatreName) {
		super();
		this.id = id;
		this.theatreName = theatreName;
	}


	
	
	
}
