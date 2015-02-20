package com.ok.onlineshop.manager;

import java.math.BigDecimal;

import com.ok.onlineshop.dao.AddressDao;
import com.ok.onlineshop.dao.PaymentDao;
import com.ok.onlineshop.dao.UserDao;
import com.ok.onlineshop.model.Address;
import com.ok.onlineshop.model.Payment;
import com.ok.onlineshop.model.User;

// @Stateless
public class UserManager {

	// newUser adds a new user to DB and returns a signed in User object
	public User newUser(String username, String password, String email) {
		User user = UserDao.addUser(username, password, email);
		if (this.validUser(user)) {
			return user;
		}
		else {
			return null;
		}
	}

	// username and email must be unique
	public boolean validUser(User user) {
		if (UserDao.findByUsername(user.getUsername()) != null) {
			return false;
		}
		if (UserDao.findByEmail(user.getEmail()) != null) {
			return false;
		}
		return true;
	}

	public User login(String username, String password) {
		User user = UserDao.findByUsername(username);
		if (user.getPassword() == password) {
			return user;
		}
		else {
			return null;
		}
	}

	// this needs some fixing; either flag for logging in/out or null if logged out
	public User logout(String username) {
		User user = UserDao.findByUsername(username);
		user.setStatus(false);
		return user;
	}

	// returns username and password
	public String forgotUser(String email) {
		String toRet;
		User user = UserDao.findByEmail(email);
		if (user == null) {
			toRet = email + " not found";
		}
		else {
			toRet =
					"Your Username: " + user.getUsername() + "\n" + "Your Password: "
							+ user.getPassword();
		}
		return toRet;
	}

	public User findUserPay(User user) {
		BigDecimal userid = user.getUserid();
		return null;
	}

	// newPayment also creates a new billing Address as well
	public Payment newPayment(String creditName, long creditNum, int expiration,
			String recipient, String street1, String street2, String city,
			String state, int zip, User user) {
		Address billing =
				AddressDao.addAddress(recipient, street1, street2, city, state, zip,
						user);
		Payment payment =
				PaymentDao.addPayment(creditName, creditNum, expiration, billing, user);
		return payment;
	}

	// if user online, newAddress maps a new shipping address to user account
	public Address newAddress(String recipient, String street1, String street2,
			String city, String state, int zip, User user) {
		Address address =
				AddressDao.addAddress(recipient, street1, street2, city, state, zip,
						user);
		return address;
	}
}
