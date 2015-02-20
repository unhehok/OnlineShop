package com.ok.onlineshop.manager;

import java.math.BigDecimal;
import java.util.List;

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
		if ((this.invalidUsername(username) == null)
				|| (this.invalidEmail(email) == null)) {
			User user = UserDao.addUser(username, password, email);
			return user;
		}
		else {
			return null;
		}
	}

	// returns NULL if username is VALID
	public String invalidUsername(String username) {
		if (UserDao.findByUsername(username) != null) {
			String errorMsg =
					"cannot create user: username[" + username + "] already exists";
			return errorMsg;
		}
		return null;
	}

	// returns NULL if email is VALID
	public String invalidEmail(String email) {
		if (UserDao.findByEmail(email) != null) {
			String errorMsg =
					"cannot create user: email[" + email + "] already exists";
			return errorMsg;
		}
		return null;
	}

	public User login(String username, String password) {
		BigDecimal userid = UserDao.findByUsername(username);
		User user = UserDao.findById(userid);
		if (user.getPassword() == password) {
			return user;
		}
		else {
			return null;
		}
	}

	// this needs some fixing; either flag for logging in/out or null if logged out
	public User logout(String username) {
		BigDecimal userid = UserDao.findByUsername(username);
		User user = UserDao.findById(userid);
		user.setStatus(false);
		return user;
	}

	// returns username and password
	public String forgotUser(String email) {
		String toRet;
		BigDecimal userid = UserDao.findByEmail(email);
		User user = UserDao.findById(userid);
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

	public boolean validPayment() {
		// write conditions for payment
		return true;
	}

	public boolean validAddress() {
		// write conditions for address
		return true;
	}

	// newPayment also creates a new billing Address as well
	public Payment newPayment(String creditName, long creditNum, short exp,
			String recipient, String street1, String street2, String city,
			String state, int zip, User user) {
		if (this.validAddress()) {
			if (this.validPayment()) {
				Address billing =
						AddressDao.addAddress(recipient, street1, street2, city, state,
								zip, user);
				Payment payment =
						PaymentDao.addPayment(creditName, creditNum, exp, billing, user);
				return payment;
			}
		}
		return null;
	}

	// if user online, newAddress maps a new shipping address to user account
	public Address newAddress(String recipient, String street1, String street2,
			String city, String state, int zip, User user) {
		if (this.validAddress()) {
			Address address =
					AddressDao.addAddress(recipient, street1, street2, city, state, zip,
							user);
			return address;
		}
		return null;
	}

	// finds all UNIQUE (currently not unique) addresses of specified user
	public List<Address> findAddresses(User user) {
		List<Address> userAddress = AddressDao.findByUser(user.getUserid());
		return userAddress;
	}

	public List<Payment> findPayments(User user) {
		List<Payment> userPays = PaymentDao.findByUser(user.getUserid());
		return userPays;
	}
}
