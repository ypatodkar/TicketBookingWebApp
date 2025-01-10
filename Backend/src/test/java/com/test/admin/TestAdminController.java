package com.test.admin;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.app.controller.AdminController;
import com.app.dto.TheatreDto;
import com.app.pojos.Gender;
import com.app.pojos.Role;
import com.app.pojos.Screen;
import com.app.pojos.Theatre;
import com.app.pojos.TheatreStatus;
import com.app.pojos.User;
import com.app.service.ITheatreService;

class TestAdminController {
	
	@InjectMocks
	AdminController adminController;
	
	@Mock
	private ITheatreService theatreService;
	
	Theatre theatre;
	User user;
	Screen sc3;
	final int userId = 9;
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		user=new User();
		user.setFirstName("Raj");
		user.setLastName("Kale");
		user.setEmail("rajkale@gmail.com");
		user.setGender(Gender.Male);
		user.setPassword("raj@123");
		user.setPhone("7550113264");
		user.setDob(LocalDate.parse("1997-09-17"));
		user.setRole(Role.ROLE_USER);
		
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
		theatre.setUser(user);
		theatre.setScreens(screens);
		theatre.setNumberOfScreens(2);
		
		
	}
	
	@Test
	void testAddTheatre() {
		when(theatreService.addTheatre(theatre, user.getEmail())).thenReturn(theatre);
	}
	
	@Test
	void testAddScreen() {
		when(theatreService.addScreen(sc3,theatre.getId())).thenReturn(sc3);
	}
}
