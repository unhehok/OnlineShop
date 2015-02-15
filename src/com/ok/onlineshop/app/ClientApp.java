package com.ok.onlineshop.app;

import com.ok.onlineshop.dao.UserDao;
import com.ok.onlineshop.model.User;

public class ClientApp {

	public static void main(String[] args) {
		User user = UserDao.findById(1);
		System.out.println(user);
	}
}
