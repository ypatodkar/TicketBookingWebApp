package com.app.pojos;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "show_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(value= {"screens"})
@SQLDelete(sql = "UPDATE show_details SET show_status = 'CANCELLED' WHERE id=?", check=ResultCheckStyle.COUNT)
//@Where(clause = "show_status <> 'CANCELLED'")
public class Show extends BaseEntity{

	@NotNull(message = "Please Enter Start Time")
	@JsonSerialize(using = LocalTimeSerializer.class)
	private LocalTime startTime;
	@NotNull(message = "Please Enter End Time")
	@JsonSerialize(using = LocalTimeSerializer.class)
	private LocalTime endTime;
	@ManyToOne
	@JoinColumn(name = "movie_id",nullable = false)
	private Movie movie;
	@ManyToOne
	@JoinColumn(name = "screen_id", nullable = false)
	private Screen screen;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ShowStatus showStatus;
	@NotNull(message = "gold price cannot be empty")
	private int goldPrice;
	@NotNull(message = "gold price cannot be empty")
	private int diamondPrice;
	@NotNull(message = "gold price cannot be empty")
	private int silverPrice;
	@NotNull(message="show date cannot be empty")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate showDate;
	
	@Override
	public String toString() {
		return "Show [startTime=" + startTime + ", endTime=" + endTime + ", movie=" + movie
				+ ", screen=" + screen + ", showStatus=" + showStatus + ", goldPrice=" + goldPrice + ", diamondPrice="
				+ diamondPrice + ", silverPrice=" + silverPrice + "]";
	}
}
