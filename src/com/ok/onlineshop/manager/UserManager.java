package com.ok.onlineshop.manager;

import javax.ejb.Stateless;

import com.ok.onlineshop.dao.UserDao;
import com.ok.onlineshop.model.User;

@Stateless
public class UserManager implements UserInterface {

	public User newUser(String username, String password, String email) {
		User ret = new User();
		ret = UserDao.addUser(username, password, email);
		System.out.println(ret);
		return ret;
	}
}
