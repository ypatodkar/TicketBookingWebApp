package com.app.owner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.app.controller.UserController;
import com.app.dto.OngoingShowDto;
import com.app.dto.UpdateShowDto;
import com.app.pojos.Gender;
import com.app.pojos.Movie;
import com.app.pojos.Role;
import com.app.pojos.Screen;
import com.app.pojos.Show;
import com.app.pojos.ShowStatus;
import com.app.pojos.Theatre;
import com.app.pojos.TheatreStatus;
import com.app.pojos.User;
import com.app.service.IShowService;
import com.app.service.ShowServiceImpl;
import com.app.service.UserServiceImpl;

class TestOwnerController {
	@InjectMocks
	UserController userController;
	
	@Mock
	UserServiceImpl userService;
	@Mock
	ShowServiceImpl showService;
	
	User owner;
	Show show;
	Theatre theatre;
	
	List<OngoingShowDto> ongoingShows= new ArrayList<OngoingShowDto>();
	UpdateShowDto updateShowDto=new UpdateShowDto();
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		owner=new User();
		owner.setId(1);
		owner.setFirstName("Raj");
		owner.setLastName("Kale");
		owner.setEmail("rajkale@gmail.com");
		owner.setGender(Gender.Male);
		owner.setPassword("raj@123");
		owner.setPhone("7550113264");
		owner.setDob(LocalDate.parse("1997-09-17"));
		owner.setRole(Role.ROLE_THEATREOWNER);
		
		show= new Show();
		show.setDiamondPrice(500);
		show.setEndTime(LocalTime.parse("10:15:00"));
		show.setGoldPrice(350);
		show.setId(1);
		show.setMovie(new Movie());
		show.setScreen(new Screen());
		show.setShowDate(LocalDate.parse("2022-04-14"));
		show.setShowStatus(ShowStatus.UPCOMING);
		show.setSilverPrice(250);
		show.setStartTime(LocalTime.parse("08:00:00"));
		
		OngoingShowDto og1=new OngoingShowDto();
		og1.setId(1);
		og1.setEndTime(LocalTime.now());
		og1.setPoster("Poster link");
		og1.setShowDate(LocalDate.now());
		og1.setShowStatus(ShowStatus.UPCOMING);
		og1.setStartTime(LocalTime.parse("20:00:00"));
		og1.setTitle("Movie Title");
		
		OngoingShowDto og2=new OngoingShowDto();
		og2.setId(2);
		og2.setEndTime(LocalTime.now());
		og2.setPoster("Poster link");
		og2.setShowDate(LocalDate.now());
		og2.setShowStatus(ShowStatus.UPCOMING);
		og2.setStartTime(LocalTime.parse("20:00:00"));
		og2.setTitle("Movie Title");
	
		ongoingShows.add(og1);
		ongoingShows.add(og2);
		
		
		Screen sc1= new Screen();
		Screen sc2= new Screen();
		
		List<Screen> screens = new ArrayList<Screen>();
		screens.add(sc1);
		screens.add(sc2);
		
		theatre=new Theatre();
		theatre.setId(1);
		theatre.setLastUpdated(LocalDateTime.now());
		theatre.setLastUpdatedBy("Raj");
		theatre.setStatus(TheatreStatus.ACTIVE);
		theatre.setTheatreCity("PUNE");
		theatre.setTheatreContactNumber("7550113264");
		theatre.setTheatrePincode("444203");
		theatre.setTheatreName("MahaRaja Multiplex");
		theatre.setTheatreState("Maharashtra");
		theatre.setUser(owner);
		theatre.setScreens(screens);
		theatre.setNumberOfScreens(2);
	}
	
	@Test
	void testGetShow() {
		when(showService.getShowbyId(show.getId())).thenReturn(updateShowDto);
	}
	
	@Test 
	void testGetAllShows() {
		when(showService.getAllShowsByTheatre(theatre.getId(), LocalDate.now()))
		.thenReturn(ongoingShows);
	}

}
