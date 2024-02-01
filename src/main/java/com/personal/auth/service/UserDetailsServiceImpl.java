package com.personal.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.personal.auth.repository.UserMongoRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserMongoRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String useremail) throws UsernameNotFoundException {
		return userRepo.findByUserEmail(useremail)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}

}
