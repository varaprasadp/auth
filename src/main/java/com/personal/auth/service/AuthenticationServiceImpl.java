package com.personal.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.personal.auth.model.AuthenticationResponse;
import com.personal.auth.model.User;
import com.personal.auth.repository.UserMongoRepository;
import com.personal.auth.utils.Cryptic;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
	@Autowired
	private UserMongoRepository userMongoRepository;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Override
	public AuthenticationResponse register(User request) {
		User user = new User();
		user.setEmail(request.getUsername());
		user.setPassword(Cryptic.hash(request.getPassword()));
		user = userMongoRepository.save(user);
		String token = jwtService.generateToken(user);
		AuthenticationResponse authResponse = new AuthenticationResponse(token);
		return authResponse;
	}
	
	@Override
	public AuthenticationResponse authenticate(User request) {
		User user = userMongoRepository.findByUserEmail(request.getUsername()).orElseThrow();
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getUsername(), 
						request.getPassword()));
		String token = jwtService.generateToken(user);
		return new AuthenticationResponse(token);
	}
	
}
