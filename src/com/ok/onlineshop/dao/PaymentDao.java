package com.ok.onlineshop.dao;

import java.math.BigDecimal;
import java.util.List;

import com.ok.onlineshop.model.Address;
import com.ok.onlineshop.model.Payment;
import com.ok.onlineshop.model.User;

public class PaymentDao extends GenericDao {

	public static Payment addPayment(String creditName, long creditNum,
			short expiration, Address billing, User user) {
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

	public static List<Payment> findAllPayment() {
		List<Payment> toRet = GenericDao.findAll(Payment.class);
		return toRet;
	}

	public static List<Payment> findByUser(BigDecimal userid) {
		String hql = "from PAYMENT pay where pay.userAccount=" + userid;
		List<Payment> userPays = GenericDao.findList(hql);
		return userPays;
	}
}
