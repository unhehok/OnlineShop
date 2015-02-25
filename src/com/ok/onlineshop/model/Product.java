package com.ok.onlineshop.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Product implements Serializable {

	private static final long	serialVersionUID	= 1L;
	@SequenceGenerator(name = "PRODUCT_SEQ_GEN", sequenceName = "PRODUCT_SEQ",
			initialValue = 1)
	@Id
	@GeneratedValue(generator = "PRODUCT_SEQ_GEN")
	@Column(name = "PRODUCT_ID")
	private BigDecimal				productId;
	@Id
	@Column(name = "PRODUCT_NAME", nullable = false)
	private String						productName;
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	private Category					category;
	@Id
	@Column(name = "VENDOR", nullable = false)
	private String						vendor;
	@Id
	@Column(name = "UNITPRICE", nullable = false)
	private double						unitPrice;
	@Id
	@Column(name = "DESCRIPTION")
	private String						description;

	// private List<Option> optionsAvail;

	public BigDecimal getProductId() {
		return this.productId;
	}

	public void setProductId(BigDecimal productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getVendor() {
		return this.vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public double getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return Product.serialVersionUID;
	}

	@Override
	public String toString() {
		return "Product [productId=" + this.productId + ", productName="
				+ this.productName + ", category=" + this.category + ", vendor="
				+ this.vendor + ", unitPrice=" + this.unitPrice + ", description="
				+ this.description + "]";
	}

}
