package com.ok.onlineshop.manager;

import com.ok.onlineshop.dao.AccountDao;
import com.ok.onlineshop.dao.AddressDao;
import com.ok.onlineshop.dao.PaymentDao;
import com.ok.onlineshop.dao.UserDao;
import com.ok.onlineshop.model.Account;
import com.ok.onlineshop.model.Address;
import com.ok.onlineshop.model.Payment;
import com.ok.onlineshop.model.User;

// @Stateless
public class UserManager {

	// newUser adds a new user to DB and returns a signed in User object
	public User newUser(String username, String password, String email) {
		User user = UserDao.addUser(username, password, email);
		user.setStatus(true);
		Account account = AccountDao.addAccount(user);
		return account.getUser();
	}

	public User login(String username, String password) {
		User user = UserDao.findByUsername(username);
		if (user.getPassword() == password) {
			user.setStatus(true);
		}
		else {
			user.setStatus(false);
		}
		return user;
	}

	public User logout(String username) {
		User user = UserDao.findByUsername(username);
		user.setStatus(false);
		return user;
	}

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
		System.out.println(toRet);
		return toRet;
	}

	// newPayment also creates a new billing Address; mapped to user if online
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

	public Account addShipping(Account account, Address shipping) {
		return AccountDao.addShippingToAccount(account, shipping);
	}

	public Account addPayment(Account account, Payment payment) {
		return AccountDao.addPayToAccount(account, payment);
	}
}
