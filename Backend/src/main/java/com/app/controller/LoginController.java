package com.app.controller;

import java.util.Collections;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.UserRepository;
import com.app.dto.UserResponseDtoWithJwt;
import com.app.pojos.LoginCredentials;
import com.app.pojos.User;
import com.app.security.JWTUtil;
import com.app.service.IUserService;
import com.sun.net.httpserver.Headers;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="http://localhost:3000")
public class LoginController {
	@Autowired
	private IUserService userService;
	@Autowired 
	private UserRepository userRepo;
    @Autowired 
    private JWTUtil jwtUtil;
    @Autowired 
    private 
    AuthenticationManager authManager;
    @Autowired 
    private PasswordEncoder passwordEncoder;
    
	@PostMapping("/login")
	public ResponseEntity<?> LoginSuccess(@RequestBody LoginCredentials body) {
		try {
			// creating an authentication token which would be sent to the authentication provider by the
			// authentication manager
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword());
            // here authManager will send the authInputToken to all the authentication providers and 
            // whichever is capable of authenticating the (username&password)token.The authentication 
            //provider will then return the authentication object fully populated.
            authManager.authenticate(authInputToken);

            String token = jwtUtil.generateToken(body.getEmail());
          User user=userRepo.findByEmail(body.getEmail()).get();
          UserResponseDtoWithJwt userWithJwt = new UserResponseDtoWithJwt(user.getId(), user.getFirstName(), user.getLastName(), user.getDob(), user.getGender(), user.getEmail(), user.getPhone(), user.getPassword(), user.getRole(), token);


          return ResponseEntity.ok()
            .body(userWithJwt);
            	 			
        }catch (AuthenticationException authExc){
            throw new RuntimeException("Invalid Login Credentials");
        }
    }
		
	@PostMapping("/register")
	public ResponseEntity<?> RegisterUser(@RequestBody @Valid User user){
		String encodedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);
        try {
			 user=userRepo.save(user);
		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException("Email Already Exists");
		}
        String token = jwtUtil.generateToken(user.getEmail());
        UserResponseDtoWithJwt userWithJwt = new UserResponseDtoWithJwt(user.getId(), user.getFirstName(), user.getLastName(), user.getDob(), user.getGender(), user.getEmail(), user.getPhone(), user.getPassword(), user.getRole(), token);
        return ResponseEntity.ok().body(userWithJwt);
		
	}
}
