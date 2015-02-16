package com.ok.onlineshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIES")
public class Category implements Serializable {

	private static final long	serialVersionUID	= 1L;
	@Id
	@Column(name = "CATEGORY_ID")
	private BigDecimal				categoryId;
	@Column(name = "CATEGORY_NAME")
	private String						categoryName;
	@OneToMany(mappedBy = "parentCategory")
	private Set<Category>			subCategories;
	@ManyToOne
	@JoinColumn(name = "PARENT_ID", referencedColumnName = "CATEGORY_ID")
	private Category					parentCategory;
	@OneToMany(mappedBy = "cat")
	private Set<Product>			catProducts;

}
