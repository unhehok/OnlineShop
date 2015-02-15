package com.ok.onlineshop.manager;

import javax.ejb.Local;

import com.ok.onlineshop.model.User;

@Local
public interface UserInterface {

	User newUser(String username, String password, String email);
}
