package com.app.dto;

import java.time.LocalDate;
import com.app.pojos.Gender;
import com.app.pojos.Role;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDtoWithJwt {
	private Integer id;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private Gender gender;
	private String email;
	private String phone;
	private String password;
	private Role role;
	private String jwtToken;
}
