package com.personal.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.personal.auth.model.AuthenticationResponse;
import com.personal.auth.model.User;
import com.personal.auth.service.AuthenticationService;

@RestController
public class AuthController {
	
	@Autowired
	AuthenticationService authenticationService;
	
	@GetMapping("/test")
	public String test() {
		return "testing";
	}
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody User request) {
		return ResponseEntity.ok(authenticationService.register(request));
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(@RequestBody User request) {
		return ResponseEntity.ok(authenticationService.authenticate(request)); 
	}
}
