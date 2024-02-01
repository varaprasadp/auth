package com.personal.auth.dao;

import java.util.Optional;

import com.personal.auth.model.User;

public interface CredsDAO {
	Optional<User> getCreds();
	User insertCreds();
}
