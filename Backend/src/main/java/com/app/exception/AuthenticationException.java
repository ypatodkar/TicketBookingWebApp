package com.app.exception;

@SuppressWarnings("serial")
public class AuthenticationException extends RuntimeException{
	
	public AuthenticationException(String msg){
		super(msg);
	}

}
