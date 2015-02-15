package com.ok.onlineshop.manager;

import javax.ejb.Remote;

import com.ok.onlineshop.model.User;

@Remote
public interface UserInterface {

	User newUser(String username, String password, String email);
}
