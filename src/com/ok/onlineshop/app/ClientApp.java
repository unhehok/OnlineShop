package com.ok.onlineshop.app;

import com.ok.onlineshop.model.User;
import com.ok.onlineshop.dao.UserDao;

public class ClientApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user = addUser("happy", "day", "woah@hoho.com");
	}
}
