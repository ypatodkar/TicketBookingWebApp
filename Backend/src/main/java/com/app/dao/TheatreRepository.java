package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.dto.ScreenDto;
import com.app.dto.TheatreDto;
import com.app.pojos.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
	@Query( "SELECT new com.app.dto.TheatreDto(t.id, t.theatreName , t.theatreState, theatreCity) from Theatre t")
	List<TheatreDto> findAllTheatres();
	
	@Query( "SELECT new com.app.dto.TheatreDto(t.id, t.theatreName) from Theatre t where t.theatreCity=?1")
	List<TheatreDto> findAllTheatresByCity(String city);
	
	@Query("SELECT new com.app.dto.ScreenDto(t.id,t.screenStatus, t.screenNumber, t.theatre.id) from Screen t where t.theatre.id=?1")
	List<ScreenDto> getAllScreenNumbers(int theatreId);
	
	@Query( "SELECT new com.app.dto.TheatreDto(t.id, t.theatreName, t.theatreState, t.theatreCity, t.theatrePincode) from Theatre t where t.id=?1")
	TheatreDto getMyTheatreById(int theatreId);
	
	@Modifying
	@Query(value="update theatre_details set status ='INACTIVE' where id = ?1",nativeQuery = true)
	int setTheatreInActive(int theatreId);
	@Query("SELECT t FROM Theatre t WHERE t.user.id=?1")
	List<Theatre> getTheatreByUserId(int userId);
}
