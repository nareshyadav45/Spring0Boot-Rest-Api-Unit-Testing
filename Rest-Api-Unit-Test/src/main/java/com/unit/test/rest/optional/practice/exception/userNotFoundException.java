package com.unit.test.rest.optional.practice.exception;


import org.springframework.stereotype.Component;


public class userNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public userNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public userNotFoundException(String message) {
		super(message);
		
	}
}
