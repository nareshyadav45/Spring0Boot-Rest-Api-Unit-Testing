package com.unit.rest.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unit.rest.test.service.WelcoemService;

@RestController
public class WelcomeRestController {

	@Autowired
	private WelcoemService welcoemService;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcomeMessage(){
		String welcomeServiceMethod = welcoemService.welcomeServiceMethod();
		return new ResponseEntity<>(welcomeServiceMethod,HttpStatus.FOUND);	
	}
	
	
}
