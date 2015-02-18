package com.ok.onlineshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {

	private static final long	serialVersionUID	= 1L;
	@Id
	@Column(name = "PRODUCT_ID")
	private BigDecimal				productId;
	@Id
	@Column(name = "PRODUCT_NAME")
	private String						productName;
	@ManyToOne
	@JoinColumn(name = "PROD_CAT_ID", referencedColumnName = "CATEGORY_ID")
	private Category					cat;
	@Id
	@Column(name = "SUPPLIER")
	private String						supplier;
	@Id
	@Column(name = "UNITPRICE")
	private float							unitPrice;
	@Id
	@Column(name = "DESCRIPTION ")
	private String						description;
	private List<Option>			optionsAvail;
}
