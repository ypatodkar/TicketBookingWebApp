package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="user_details")
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity{
	@Column(name="first_name", length = 20)
	@NotBlank(message = "first name is mandatory")
	private String firstName;
	@Column(name="last_name", length = 20)
	@NotBlank(message = "last name is mandatory")
	private String lastName;
	@NotNull(message = "date of birth is mandatory")
	@Column(name="date_of_birth")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	@Column(name="gender", length = 20)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(name="email", unique=true, length = 50)
	@NotBlank(message = "email is mandatory")
	@Pattern(regexp = "^(.+)@(.+)$", message = "the email is invalid")
	private String email;
	@Column(name="ph_no", unique=true)
	@NotBlank(message="phone number is mandatory")
	@Pattern(regexp="^[0-9]{10}$", message = "phone number not valid")
	private String phone;
	@Column(name="password", length= 255)
	@NotBlank(message="password cannot be blank")
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,255})",message = "Invalid password")
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	//login constructor -- please na hataye
	public User(
			@NotBlank(message = "email is mandatory") @Pattern(regexp = "^(.+)@(.+)$", message = "the email is invalid") String email,
			@NotBlank(message = "password cannot be blank") @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Invalid password") String password) {
		super();
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Register [firstName=" + firstName + ", lastname=" + lastName + ", dob=" + dob + ", gender=" + gender
				+ ", email=" + email + ", phone=" + phone + "]";
	}



	public User(@NotBlank(message = "first name is mandatory") String firstName,
			@NotBlank(message = "last name is mandatory") String lastName,
			@NotNull(message = "date of birth is mandatory") LocalDate dob, Gender gender,
			@NotBlank(message = "email is mandatory") @Pattern(regexp = "^(.+)@(.+)$", message = "the email is invalid") String email,
			@NotBlank(message = "phone number is mandatory") @Pattern(regexp = "^[0-9]{10}$", message = "phone number not valid") String phone,
			@NotBlank(message = "password cannot be blank") @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Invalid password") String password, Role role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.role = role;
	}
	
	
}
