package com.ok.onlineshop.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {

	@Id
	@Column(name = "ACCOUNT_ID", unique = true, nullable = false)
	private long					accountId;
	@OneToOne(mappedBy = "accountInfo")
	private User					user;
	@OneToMany(mappedBy = "userAccount")
	private List<Payment>	payMethod;
	@OneToMany(mappedBy = "userAccount")
	private Set<Address>	shipping;

	public long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(long accountId) {
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

	public Set<Address> getShipping() {
		return this.shipping;
	}

	public void setShipping(Set<Address> shipping) {
		this.shipping = shipping;
	}

}
