package com.ok.onlineshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "CATEGORIES")
public class Category implements Serializable {

	private static final long				serialVersionUID	= 1L;
	@SequenceGenerator(name = "CAT_SEQ_GEN", sequenceName = "CAT_SEQ",
			initialValue = 1)
	@Id
	@GeneratedValue(generator = "CAT_SEQ_GEN")
	@Column(name = "CATEGORY_ID", unique = true, nullable = false)
	private BigDecimal							categoryId;
	@Column(name = "CATEGORY_NAME", nullable = false)
	private String									categoryName;
	@ManyToOne
	@JoinColumn(name = "PARENT_CAT_ID", referencedColumnName = "CATEGORY_ID")
	private Category								parentCategory;
	transient private Set<Category>	subCategories;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	@Cascade({ CascadeType.SAVE_UPDATE })
	transient private Set<Product>	catProducts;

	public BigDecimal getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(BigDecimal categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Category getParentCategory() {
		return this.parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public Set<Category> getSubCategories() {
		return this.subCategories;
	}

	public void setSubCategories(Set<Category> subCategories) {
		this.subCategories = subCategories;
	}

	public Set<Product> getCatProducts() {
		return this.catProducts;
	}

	public void setCatProducts(Set<Product> catProducts) {
		this.catProducts = catProducts;
	}

	public static long getSerialversionuid() {
		return Category.serialVersionUID;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + this.categoryId + ", categoryName="
				+ this.categoryName + ", parentCategory=" + this.parentCategory + "]";
	}
}
