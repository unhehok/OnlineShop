package com.ok.onlineshop.app;

import java.util.List;

import com.ok.onlineshop.dao.CategoryDao;
import com.ok.onlineshop.dao.ProductDao;
import com.ok.onlineshop.model.Category;
import com.ok.onlineshop.model.Product;

public class ClientApp {

	public static void main(String[] args) {
		// UserManager um = new UserManager();
		// User user1 = um.newUser("happy", "happy", "happy@happy.com");
		// User user2 = um.newUser("hoop", "hoop", "hoop@happy.com");
		// um.newUser("baba", "lala", "sing@along.com");
		// um.newUser("love", "java", "so@fun.com");
		// um.newAddress("John Doe", "123 Power Rd", null, "Rockville", "MD", 12345,
		// user1);
		// um.newAddress("Sally Mom", "789 Hungry St", "Apt 31", "Falls Church", "VA",
		// 55555, user2);
		// um.newPayment("John Doe", 16161616161616l, (short) 215, "Sally Mom",
		// "789 Hungry St", "Apt 31", "Falls Church", "VA", 55555, user2);
		// List<Address> userAddresses = um.findAddresses(user2);
		// System.out.println("user2 addresses: " + userAddresses);
		// List<Payment> userPays = um.findPayments(user2);
		// System.out.println("user2 payments: " + userPays);

		Category parent1 = CategoryDao.addCat("Hoops", null);
		Category sub1 = CategoryDao.addCat("Naked", parent1);
		Category sub2 = CategoryDao.addCat("Taped", parent1);
		Category sub3 = CategoryDao.addCat("LED", parent1);

		Category parent2 = CategoryDao.addCat("Poi", null);
		Category sub4 = CategoryDao.addCat("Pod", parent2);
		Category sub5 = CategoryDao.addCat("Ninja", parent2);
		Category sub6 = CategoryDao.addCat("Sock", parent2);
		Category sub7 = CategoryDao.addCat("LED", parent2);

		List<Category> allCats = CategoryDao.findAllCats();
		// System.out.println("allCats = " + allCats);
		List<Category> allParents = CategoryDao.findAllParentCats();
		// System.out.println("allParents = " + allParents);
		List<Category> subHoops = CategoryDao.findSubCats("Hoops");
		// System.out.println("subHoops = " + subHoops);
		Category hoop = CategoryDao.findParentByName("Poi");
		// System.out.println("hoop = " + hoop);
		Category ledHoop = CategoryDao.findSubByName("Hoops", "LED");
		// System.out.println("ledHoop = " + ledHoop);

		Product metallic =
				ProductDao.addProduct("Metallic", sub1, "Gnar", 27.5,
						"metallic naked hoop from Gnar");
		Product retro =
				ProductDao.addProduct("Retro", sub1, "HoopSupplies", 24.8,
						"retro naked hoop from HoopSupplies");
		List<Product> nakedhoops = ProductDao.findByCat(sub1.getCategoryId());
		System.out.println(nakedhoops);
	}
}
