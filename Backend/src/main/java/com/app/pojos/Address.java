package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="user_address")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address extends BaseEntity{
	@NotBlank(message="city cannot be blank")
	@Column(length = 30)
	private String city;
	@NotBlank(message="city cannot be blank")
	@Column(length = 30)
	private String state;
	@NotBlank(message="pincode cannot be blank")
	@Column(length = 30)
	@Pattern(regexp = "^[1-9][0-9]{5}$", message = "pincode not valid")
	private String pincode;
	@OneToOne
	@JoinColumn(name = "user_id")
	@MapsId
	private User register;
	

	public Address(@NotBlank(message = "city cannot be blank") String city,
			@NotBlank(message = "city cannot be blank") String state,
			@NotBlank(message = "pincode cannot be blank") @Pattern(regexp = "^[1-9][0-9]{5}$", message = "pincode not valid") String pincode,
			User register) {
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.register = register;
	}

	
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", pincode=" + pincode + ", register=" + register + "]";
	}
	
}
