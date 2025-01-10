package com.app.dto;

import com.app.pojos.Theatre;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheatreAndOwnerDto {
	private Theatre theatre;
	private String email;

}
