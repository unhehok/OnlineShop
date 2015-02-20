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
		payment.setUser(user);
		if (payment.validPayment()) {
			GenericDao.save(payment);
			return payment;
		}
		else {
			return null;
		}
	}

	public static void updatePayment(Payment entity) {
		GenericDao.save(entity);
	}
}
