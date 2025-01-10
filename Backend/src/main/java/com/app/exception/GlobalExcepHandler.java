package com.app.exception;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExcepHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> map = ex.getFieldErrors().stream() //Stream<FieldError>
				.collect(Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage));
				return ResponseEntity.badRequest().body(map);
				
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> GlobalRuntimeExceptionHandler(RuntimeException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
		ErrorResponse resp=new ErrorResponse(ex.getMessage(),LocalDateTime.now());
		System.out.println("reached here");
		return ResponseEntity.badRequest().body(resp);
	}
	
}
