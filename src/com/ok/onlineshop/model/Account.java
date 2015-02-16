package com.ok.onlineshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {

	private static final long	serialVersionUID	= 1L;
	@Id
	@Column(name = "ACCOUNT_ID", unique = true, nullable = false)
	private BigDecimal				accountId;
	@OneToOne(mappedBy = "accountInfo")
	private User							user;
	@OneToMany(mappedBy = "userAccount")
	private List<Payment>			payMethod;
	@OneToMany(mappedBy = "userAccount")
	private List<Address>			shipping;

	public BigDecimal getAccountId() {
		return this.accountId;
	}

	public void setAccountId(BigDecimal accountId) {
		this.accountId = accountId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Payment> getPayMethod() {
		return this.payMethod;
	}

	public void setPayMethod(List<Payment> payMethod) {
		this.payMethod = payMethod;
	}

	public List<Address> getShipping() {
		return this.shipping;
	}

	public void setShipping(List<Address> shipping) {
		this.shipping = shipping;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + this.accountId + ", username="
				+ this.user.getUsername() + ", payMethod=" + this.payMethod.toArray()
				+ ", shipping=" + this.shipping.toArray() + "]";
	}

}
