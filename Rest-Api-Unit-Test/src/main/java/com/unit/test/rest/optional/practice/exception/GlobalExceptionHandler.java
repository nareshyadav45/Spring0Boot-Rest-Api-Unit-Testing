package com.unit.test.rest.optional.practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(userNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(userNotFoundException ex){
		String message = ex.getMessage();
		return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);	
	}
	

}
