package com.ok.onlineshop.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ok.onlineshop.model.User;

public class UserDao extends GenericDao {

	public static User addUser(String username, String password, String email) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		Date registration = new Date();
		user.setRegistrationDate(registration);
		GenericDao.save(user);
		return user;
	}

	public static void updateUser(User entity) {
		GenericDao.save(entity);
	}

	public static void deleteUser(User entity) {
		GenericDao.delete(entity);
	}

	public static User findById(BigDecimal userid) {
		User user = (User) GenericDao.findById(User.class, userid);
		return user;
	}

	public static List<User> findAllUsers() {
		List<User> allIds = GenericDao.findAll(User.class);
		// System.out.println(allIds);
		// System.out.println();
		// List<User> allUsers = new ArrayList<User>();
		// for (User id : allIds) {
		// User user = (User) GenericDao.findById(User.class, id.getUserid());
		// allUsers.add(user);
		// }
		return allIds;
	}

	public static BigDecimal findByEmail(String email) {
		String sql = "SELECT USERID FROM USERS WHERE EMAIL LIKE '" + email + "'";
		BigDecimal userid = GenericDao.findOne(sql);
		return userid;
	}

	public static BigDecimal findByUsername(String username) {
		String sql =
				"SELECT USERID FROM USERS WHERE USERNAME LIKE '" + username + "'";
		BigDecimal userid = GenericDao.findOne(sql);
		return userid;
	}

}
