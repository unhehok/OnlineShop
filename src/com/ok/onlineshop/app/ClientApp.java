package com.ok.onlineshop.app;

import com.ok.onlineshop.dao.UserDao;
import com.ok.onlineshop.model.User;

public class ClientApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserDao u = new UserDao();
		User user = u.addUser("happy", "day", "woah@hoho.com");
		System.out.println(user);
	}
}
