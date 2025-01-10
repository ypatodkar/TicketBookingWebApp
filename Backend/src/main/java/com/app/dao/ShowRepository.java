package com.app.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.dto.BookShowDto;
import com.app.dto.OngoingShowDto;
import com.app.dto.ShowTimeDto;
import com.app.dto.UpdateShowDto;
import com.app.pojos.Screen;
import com.app.pojos.Show;

public interface ShowRepository extends JpaRepository<Show, Integer> {
	// Query to find the shows on particular screen
	List<Show> findByScreen(Screen screen);

	// To get all movies in a theatre
	// Query to get all the movies in particular theatre
	// NATIVE QUERY ::
	// SELECT show_details.id,
	// show_details.end_time,show_details.start_time,show_details.show_date,movie_details.title,movie_details.poster
	// FROM show_details JOIN screen_details ON
	// screen_details.id=show_details.screen_id
	// JOIN movie_details ON movie_details.imdb_id=show_details.movie_id WHERE
	// theatre_id=?1
	@Query(value = "select new com.app.dto.OngoingShowDto(s.id,s.endTime,s.startTime,s.showDate,m.title,m.poster,s.showStatus) from Show s "
			+ "join s.movie m "
			+ "join s.screen sc "
			+ "join sc.theatre t "
			+ "where t.user.id=:userId")
	List<OngoingShowDto> getAllShows(@Param(value = "userId") int userId);

	// to update a show we need some fields to update --> updateShowDto
	@Query(value = "select new com.app.dto.UpdateShowDto(s.id,s.startTime,s.endTime,s.screen.id,s.showStatus,s.goldPrice,s.diamondPrice,s.silverPrice,s.showDate) from Show s "
			+ "where s.id=:showId")
	UpdateShowDto getShowById(@Param(value = "showId") int showId);

	@Modifying
	@Query(value = "update show_details set diamond_price= ?1, end_time=?2, gold_price=?3, show_status=?4, silver_price=?5, start_time=?6, show_date=?7, screen_id=?8 where id=?9 ", nativeQuery = true)
	int updateShow(int diamondPrice, LocalTime endTime, int goldPrice, String showStatus, int silverPrice,
			LocalTime startTime, LocalDate showDate, int screens, int showId);

	@Query(value = "select * from show_details where screen_id in (select id from screen_details where theatre_id in (select id from theatre_details where theatre_city =?1)) and movie_id=?2", nativeQuery = true)
	List<Show> getShowsByCity(String city, String movieId);

	// http://localhost:8080/api/user/getShowsByCity/Pune/tt10872600

	@Query(value = "select new com.app.dto.ShowTimeDto "
			+ "(m.imdbId, sc.id,t.id,s.showDate,s.startTime,t.theatreName,s.id) from Show s "
			+ "join s.screen sc "
			+ "join s.movie m "
			+ "join sc.theatre t "
			+ "where s.showDate = :showDate and t.theatreCity =:city and m.imdbId=:movieId and s.showStatus='UPCOMING'")
	List<ShowTimeDto> getShowsByDate(@Param(value = "showDate") LocalDate showDate, @Param(value = "city") String city,
			@Param(value = "movieId") String movieId);

	// @Query(value="select * from show_details as shd "
	// + "join screen_details scd on shd.screen_id=scd.id "
	// + "join movie_details as md on shd.movie_id=md.imdb_id "
	// + "join theatre_details as td on td.id=scd.theatre_id "
	// + "where shd.show_date=?1 and td.theatre_city=?2 and shd.movie_id=?3",
	// nativeQuery = true)
	// List<ShowTimeDto> getShowsByDate(LocalDate showDate,String city, String
	// movieId);
	//
	@Query(value = "select new com.app.dto.OngoingShowDto(s.id,s.endTime,s.startTime,s.showDate, m.title,m.poster, s.showStatus) from Show s "
			+ "join s.movie m "
			+ "join s.screen sc "
			+ "where sc.theatre.id=:theatreId and s.showDate=:showDate and s.showStatus='UPCOMING'")
	List<OngoingShowDto> getAllShowsByTheatreByDate(@Param(value = "theatreId") int theatreId,
			@Param(value = "showDate") LocalDate showDate);

	@Query(value = "select new com.app.dto.BookShowDto(sh.id, t.theatreName, t.theatreCity, md.title, sc.screenNumber, sh.startTime, md.language, md.rated, sh.showDate,sh.goldPrice,sh.diamondPrice,sh.silverPrice) "
			+ "from Show sh "
			+ "join sh.movie md "
			+ "join sh.screen sc "
			+ "join sc.theatre t "
			+ "where sh.id=:showId")
	BookShowDto getShowDetailsByShowId(@Param(value = "showId") int showId);

	@Query(value = "select movie_id from show_details where id = ?1", nativeQuery = true)
	String getImdbIdFromShowId(int showID);

	// updating a running show to completed after the current time and current date
	@Modifying
	@Query(value = "update show_details set show_status='COMPLETED' where show_status='RUNNING' and end_time<=?1 and show_date=?2", nativeQuery = true)
	int updateStatus(LocalTime endTime, LocalDate date);

	// updating a upcoming show to running when the time is after the start time of
	// the show and current date
	@Modifying
	@Query(value = "update show_details set show_status='RUNNING' where show_status='UPCOMING' and start_time<=:timeNow and end_time >=:timeNow and show_date=:dateToday", nativeQuery = true)
	int updateUpcomingToRunning(@Param(value = "timeNow") LocalTime timeNow,
			@Param(value = "dateToday") LocalDate date);

	@Query("select sc.id from Screen sc "
			+ "where sc.theatre.id=:theatreId and sc.screenNumber=:screenNumber")
	Integer getScreenIdByScreenNumber(@Param(value = "screenNumber") int screenNumber,
			@Param(value = "theatreId") int theatreId);

	// method to return theatre by show
	@Query("select t.id from Show s "
			+ "join s.screen sc "
			+ "join sc.theatre t "
			+ "where s.id=:showId")
	int getTheatreIdByShowId(@Param(value = "showId") int showId);
}
