package com.ok.onlineshop.dao;

import java.math.BigDecimal;

import com.ok.onlineshop.model.Category;
import com.ok.onlineshop.model.Product;

public class ProductDao extends GenericDao {

	public static Product addProduct(String productName, Category category,
			String vendor, double unitPrice, String description) {
		Product product = new Product();
		product.setProductName(productName);
		product.setCategory(category);
		product.setVendor(vendor);
		product.setUnitPrice(unitPrice);
		product.setDescription(description);
		GenericDao.save(product);
		CategoryDao.updateCat(category);
		return product;
	}

	public static void updateProduct(Product entity) {
		GenericDao.save(entity);
	}

	public static void deleteProduct(Product entity) {
		GenericDao.delete(entity);
	}

	public static Product findById(BigDecimal productId) {
		Product product = (Product) GenericDao.findById(Product.class, productId);
		return product;
	}
}
