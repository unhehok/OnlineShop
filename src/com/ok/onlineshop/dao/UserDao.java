package com.ok.onlineshop.dao;

import java.util.Date;

import com.ok.onlineshop.model.User;

public class UserDao extends GenericDao {

	public static User addUser(String username, String password, String email) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		Date registration = new Date();
		user.setRegistrationDate(registration);
		System.out.println(user);
		GenericDao.save(user);
		return user;
	}

	public static User findById(long userid) {
		User user = (User) GenericDao.findById("USERS", userid);
		return user;
	}
}
