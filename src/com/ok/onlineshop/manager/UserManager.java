package com.ok.onlineshop.manager;

import com.ok.onlineshop.dao.UserDao;
import com.ok.onlineshop.model.User;

// @Stateless
public class UserManager {

	@Override
	public User newUser(String username, String password, String email) {
		User user = UserDao.addUser(username, password, email);
		user.setStatus(true);
		user.setAccountInfo(null);
		return user;
	}

	public User login(String username, String password) {

	}
}
