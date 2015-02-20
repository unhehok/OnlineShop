package com.ok.onlineshop.dao;

import java.math.BigDecimal;
import java.util.List;

import com.ok.onlineshop.model.Category;

public class CategoryDao extends GenericDao {

	public static Category addCat(String categoryName, Category parentCategory) {
		Category category = new Category();
		category.setCategoryName(categoryName);
		category.setParentCategory(parentCategory);
		GenericDao.save(category);
		return category;
	}

	public static void updateCat(Category entity) {
		GenericDao.save(entity);
	}

	public static void deleteCat(Category entity) {
		GenericDao.delete(entity);
	}

	public static Category findById(BigDecimal categoryId) {
		Category category =
				(Category) GenericDao.findById(Category.class, categoryId);
		return category;
	}

	public static List<Category> findAllCats() {
		List<Category> allCats = GenericDao.findAll(Category.class);
		return allCats;
	}

	public static List<Category> findAllParentCats() {
		String sql = "SELECT * FROM CATEGORIES cat WHERE cat.PARENT_CAT_ID IS NULL";
		List<Category> parentCats = GenericDao.findList(sql);
		return parentCats;
	}

	public static List<Category> findSubCats(String parentCategory) {
		BigDecimal parentId =
				GenericDao
				.findOne("SELECT CATEGORY_ID FROM CATEGORIES WHERE CATEGORY_NAME LIKE '"
						+ parentCategory + "'");
		String sql =
				"SELECT * FROM CATEGORIES WHERE PARENT_CAT_ID LIKE '" + parentId + "'";
		List<Category> subCats = GenericDao.findList(sql);
		return subCats;
	}

	public static Category findParentByName(String categoryName) {
		String sql =
				"SELECT CATEGORY_ID FROM CATEGORIES WHERE CATEGORY_NAME LIKE '"
						+ categoryName + "' AND PARENT_CAT_ID IS NULL";
		BigDecimal categoryId = GenericDao.findOne(sql);
		Category category =
				(Category) GenericDao.findById(Category.class, categoryId);
		return category;
	}

	public static Category findSubByName(String parentName, String subName) {
		Category parent = CategoryDao.findParentByName(parentName);
		String sql =
				"SELECT CATEGORY_ID FROM CATEGORIES WHERE CATEGORY_NAME LIKE '"
						+ subName + "' AND PARENT_CAT_ID LIKE " + parent.getCategoryId();
		BigDecimal categoryId = GenericDao.findOne(sql);
		Category category =
				(Category) GenericDao.findById(Category.class, categoryId);
		return category;
	}
}
