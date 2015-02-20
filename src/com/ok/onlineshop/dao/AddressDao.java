package com.ok.onlineshop.dao;

import java.math.BigDecimal;
import java.util.List;

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
		address.setUser(user);
		if (address.validAddress()) {
			GenericDao.save(address);
			return address;
		}
		else {
			return null;
		}

	}

	public static void updateAddress(Address entity) {
		GenericDao.save(entity);
	}

	public static List<Address> findAllAddress() {
		List<Address> toRet = GenericDao.findAll(Address.class);
		return toRet;
	}

	public static List<Address> findByUser(BigDecimal userid) {
		String hql = "from ADDRESS add where add.userAccount=" + userid;
		List<Address> userAddress = GenericDao.findList(hql);
		return userAddress;
	}
}
