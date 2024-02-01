package com.personal.auth.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.personal.auth.model.User;
import com.personal.auth.repository.UserRepository;

public class CredsDAOImpl implements CredsDAO {
	
	@Autowired
	UserRepository credsRepo;

	@Override
	public Optional<User> getCreds() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public User insertCreds() {
		// TODO Auto-generated method stub
		return null;
	}

}
