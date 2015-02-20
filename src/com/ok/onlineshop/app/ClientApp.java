package com.ok.onlineshop.app;

import com.ok.onlineshop.manager.UserManager;

public class ClientApp {

	public static void main(String[] args) {
		UserManager um = new UserManager();
		User user1 = um.newUser("happy", "happy", "happy@happy.com");
		User user2 = um.newUser("hoop", "hoop", "hoop@happy.com");

		// Category parent1 = CategoryDao.addCat("Hoops", null);
		// Category sub1 = CategoryDao.addCat("Naked", parent1);
		// Category sub2 = CategoryDao.addCat("Taped", parent1);
		// Category sub3 = CategoryDao.addCat("LED", parent1);
		//
		// Category parent2 = CategoryDao.addCat("Poi", null);
		// Category sub4 = CategoryDao.addCat("Pod", parent2);
		// Category sub5 = CategoryDao.addCat("Ninja", parent2);
		// Category sub6 = CategoryDao.addCat("Sock", parent2);
		// Category sub7 = CategoryDao.addCat("LED", parent2);
		//
		// List<Category> allCats = CategoryDao.findAllCats();
		// // System.out.println("allCats = " + allCats);
		// List<Category> allParents = CategoryDao.findAllParentCats();
		// // System.out.println("allParents = " + allParents);
		// List<Category> subHoops = CategoryDao.findSubCats("Hoops");
		// // System.out.println("subHoops = " + subHoops);
		// Category hoop = CategoryDao.findParentByName("Hoops");
		// // System.out.println("hoop = " + hoop);
		// Category ledHoop = CategoryDao.findSubByName("Hoops", "LED");
		// // System.out.println("ledHoop = " + ledHoop);
		//
		// Product metallic =
		// ProductDao.addProduct("Metallic", sub1, "Gnar", 27.5,
		// "metallic naked hoop from Gnar");
	}
}
