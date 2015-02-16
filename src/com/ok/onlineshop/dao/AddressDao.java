package com.ok.onlineshop.dao;

import com.ok.onlineshop.model.Address;
import com.ok.onlineshop.model.User;

public class AddressDao extends GenericDao {

	public static Address addAddress(String recipient, String street1,
			String street2, String city, String state, int zip, User user) {
		Address address = new Address();
		address.setRecipient(recipient);
		address.setStreet1(street1);
		address.setStreet2(street2);
		address.setCity(city);
		address.setState(state);
		address.setZip(zip);
		if (user.isStatus()) {
			address.setUserAccount(user.getAccountInfo());
		}
		else {
			address.setUserAccount(null);
		}
		if (address.validAddress()) {
			GenericDao.save(address);
		}
		return address;
	}

	// public static Address setUserForAddress(Address address, User user) {
	// Account userAccount = user.getAccountInfo();
	// Account updatedAccount =
	// AccountDao.addShippingToAccount(userAccount, address);
	// Object[] addresses = updatedAccount.getShipping().toArray();
	// Address addWithUser = (Address) addresses[addresses.length - 1];
	// return addWithUser;
	// }
}
