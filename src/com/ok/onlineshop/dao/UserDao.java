package com.ok.onlineshop.dao;

import java.util.Date;

import com.ok.onlineshop.model.User;

public class UserDao extends GenericDao {

	public static User addUser(String username, String password, String email) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		// user.setUserid(100);
		Date registration = new Date();
		user.setRegistrationDate(registration);
		System.out.println(user);
		GenericDao.save(user);
		return user;
	}
}
