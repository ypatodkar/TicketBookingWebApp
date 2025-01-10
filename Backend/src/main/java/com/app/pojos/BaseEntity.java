package com.app.pojos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	

	@Override
	public String toString() {
		return "BaseEntity [id=" + id + "]";
	}
	
	
	
}
