package com.ok.onlineshop.dao;

import java.util.ArrayList;
import java.util.List;

import com.ok.onlineshop.model.Account;
import com.ok.onlineshop.model.Address;
import com.ok.onlineshop.model.Payment;
import com.ok.onlineshop.model.User;

public class AccountDao extends GenericDao {

	public static Account addAccount(User user) {
		Account account = new Account();
		account.setAccountId(user.getUserid());
		account.setUser(user);
		GenericDao.save(account);
		user.setAccountInfo(account);
		GenericDao.save(user);
		return account;
	}

	public static Account addPayToAccount(Account account, Payment payment) {
		List<Payment> payMethods = account.getPayMethod();
		if (payMethods == null) {
			payMethods = new ArrayList<Payment>();
		}
		payMethods.add(payment);
		payment.setUserAccount(account);
		GenericDao.save(payment);
		account.setPayMethod(payMethods);
		GenericDao.save(account);
		return account;
	}

	public static Account addShippingToAccount(Account account, Address shipping) {
		List<Address> addresses = account.getShipping();
		if (addresses == null) {
			addresses = new ArrayList<Address>();
		}
		shipping.setUserAccount(account);
		addresses.add(shipping);
		GenericDao.save(shipping);
		account.setShipping(addresses);
		GenericDao.save(account);
		return account;
	}
}
