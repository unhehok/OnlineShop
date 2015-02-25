package com.ok.onlineshop.manager;

import com.ok.onlineshop.dao.CategoryDao;
import com.ok.onlineshop.model.Category;

public class ProductManager {

	public Category newParentCat(String categoryName) {
		Category cat = CategoryDao.addCat(categoryName, null);
		return cat;
	}

	public Category newSubCat(String categoryName, Category parentCategory) {
		Category cat = CategoryDao.addCat(categoryName, parentCategory);
		return cat;
	}
}
