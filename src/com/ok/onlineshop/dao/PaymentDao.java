package com.ok.onlineshop.dao;

import com.ok.onlineshop.model.Address;
import com.ok.onlineshop.model.Payment;
import com.ok.onlineshop.model.User;

public class PaymentDao extends GenericDao {

	public static Payment addPayment(String creditName, long creditNum,
			int expiration, Address billing, User user) {
		Payment payment = new Payment();
		payment.setCreditName(creditName);
		payment.setCreditNum(creditNum);
		payment.setExpiration(expiration);
		payment.setBilling(billing);
		if (user.isStatus()) {
			payment.setUserAccount(user.getAccountInfo());
		}
		else {
			payment.setUserAccount(null);
		}
		if (payment.validPayment()) {
			GenericDao.save(payment);
		}
		return payment;
	}

	// public static Payment setUserForPayment(Payment payment, User user) {
	// Account userAccount = user.getAccountInfo();
	// Account updatedAccount = AccountDao.addPayToAccount(userAccount, payment);
	// Object[] payments = updatedAccount.getPayMethod().toArray();
	// Payment payWithUser = (Payment) payments[payments.length - 1];
	// return payWithUser;
	// }
}
