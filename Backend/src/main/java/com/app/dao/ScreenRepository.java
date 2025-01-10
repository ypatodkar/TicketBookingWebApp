package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.dto.NumberOfScreensDto;
import com.app.pojos.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Integer>{
			@Query(value="update screen_details set screen_status=?1 where id=?2", nativeQuery=true)
			@Modifying
			int updateScreenStatus(String status,int id);
			
			@Query(value = "select new com.app.dto.NumberOfScreensDto(t.numberOfScreens) from Theatre t "
					+ "where t.id = "
					+ "(select sc.theatre.id from Show s "
					+ " join s.screen sc"
					+ " where s.id=:showId)")
			NumberOfScreensDto getScreenNumbersByShowId(@Param(value = "showId") int showId);
			
			
			//select s.screen_number, s.screen_status from screen_details s where 
			//s.theatre_id=(select t.id from theatre_details t where t.user_id=34);
//			@Query(value = "select new com.app.dto.ScreenDto(s.id, s.screenNumber, s.screenStatus) from Screen s where s.theatre.id=(select t.id from Theatre t where t.user.id=?1)")
//			@Query(value="select new com.app.dto.ScreenDto(s.id, s.screenNumber, s.screenStatus) from Screen s "
//					+ "join s.theatre t where t.user.id=?1")
//			List<ScreenDto> getAllScreenOfOwner(int ownerId);
			
}
