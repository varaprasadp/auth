package com.personal.auth.service;

import com.personal.auth.model.AuthenticationResponse;
import com.personal.auth.model.User;

public interface AuthenticationService {
	AuthenticationResponse register(User request);
	
	AuthenticationResponse authenticate(User request);
}
