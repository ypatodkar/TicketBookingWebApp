package com.app.pojos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "theatre_details")
@Getter
@Setter
@NoArgsConstructor
@SQLDelete(sql = "UPDATE theatre_details SET status = 'INACTIVE' WHERE id=?", check=ResultCheckStyle.COUNT)
@Where(clause = "status <> 'INACTIVE'")
@JsonIgnoreProperties(value= {"screens"})
public class Theatre extends BaseEntity {
	@Column(name = "theatre_name", length = 30)
	@NotEmpty(message = "theatre name cannot be empty")
	private String theatreName;
	@Column(name = "theatre_city", length = 30)
	@NotEmpty(message = "theatre city cannot be empty")
	private String theatreCity;
	@Column(name = "theatre_contact_number", length = 30)
	@NotEmpty(message = "theatre contact number cannot be empty")
	@Pattern(regexp = "^[0-9]{10}$", message = "mobile number not valid")
	private String theatreContactNumber;
	@Column(name = "number_of_screens", length = 30)
	@NotNull(message = "number of screens cannot be empty")
	private int numberOfScreens;
	@Column(name = "theatre_state", length = 30)
	@NotEmpty(message = "theatre state cannot be empty")
	private String theatreState;
	@Column(name = "theatre_pincode", length = 30)
	@Pattern(regexp = "^[1-9][0-9]{5}$", message = "pincode not valid")
	private String theatrePincode;
	@OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Screen> screens = new ArrayList<>();
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private TheatreStatus status;
	@Column(length = 30)
	private String lastUpdatedBy;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime lastUpdated;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	@Override
	public String toString() {
		return "Theatre [theatreName=" + theatreName + ", theatreCity=" + theatreCity + ", theatreContactNumber="
				+ theatreContactNumber + ", numberOfScreens=" + numberOfScreens + ", theatreState=" + theatreState
				+ ", theatrePincode=" + theatrePincode + ", status=" + status + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", lastUpdated=" + lastUpdated + "]";
	}
	
	@PreRemove
	public void deleteTheatre() {
		this.status = TheatreStatus.INACTIVE;
	}
	
	public void addScreen(Screen screen) {
		screens.add(screen);
		screen.setTheatre(this);
	}
	
	public void removeScreen(Screen screen) {
		screens.remove(screen);
		screen.setTheatre(null);
	}
	
	
}
