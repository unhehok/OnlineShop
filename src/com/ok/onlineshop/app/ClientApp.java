package com.ok.onlineshop.app;

import com.ok.onlineshop.manager.UserManager;
import com.ok.onlineshop.model.Address;
import com.ok.onlineshop.model.Payment;
import com.ok.onlineshop.model.User;

public class ClientApp {

	public static void main(String[] args) {

		UserManager um = new UserManager();
		User newuser = um.newUser("freshers", "passers", "email@yo.so");
		System.out.println("newuser = " + newuser);
		// newuser is signed in so newpayment should have a corresponding user account
		Payment newpayment =
				um.newPayment("bob", 1234555, 1234, "helena", "street1", "street2",
						"city", "state", 12345, newuser);
		// System.out.println("newpayment = " + newpayment);
		um.newPayment("asd", 12345555, 1234, "sdfd", "street1", "street2", "city",
				"state", 453354, newuser);
		// newuser is signed in so newaddress should have corresponding user account
		Address newaddress =
				um.newAddress("johnny", "ssstreet1", "sdftreet2", "scity", "state",
						1235, newuser);
		// System.out.println("newaddress = " + newaddress);

	}
}
