package com.test.user;

import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.app.controller.UserController;
import com.app.pojos.Gender;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.service.UserServiceImpl;

class TestUserController {
	@InjectMocks
	UserController userController;
	
	@Mock
	UserServiceImpl userService;
	
	User user;
	
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
	}
	
	
	@Test
	final void testLoginUser() {
		when(userService.loginUser(user)).thenReturn(user);
	}

	@Test
	final void testRegisterUser() {
		when(userService.registerUser(user)).thenReturn(user);
	}
	
	
}
