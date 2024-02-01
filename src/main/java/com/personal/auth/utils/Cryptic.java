package com.personal.auth.utils;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Cryptic {
	
	static PasswordEncoder passwordEncoder;
	public Cryptic(PasswordEncoder pe) {
		passwordEncoder = pe;
	}

	
	
	public static String hash(String password) {
		try {
			return passwordEncoder.encode(password);
		} catch (Exception e) {
			throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
		} finally {
			password = "";
		}
	}
}
