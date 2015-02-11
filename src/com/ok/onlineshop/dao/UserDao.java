package com.ok.onlineshop.dao;

import java.util.Date;

import com.ok.onlineshop.model.User;

public class UserDao extends GenericDao<Object> {

	public User addUser(String username, String password, String email) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		Date registration = new Date();
		user.setRegistrationDate(registration);

		this.save(user);
		return user;
	}
}
