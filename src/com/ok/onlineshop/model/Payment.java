package com.ok.onlineshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "PAYMENT")
public class Payment implements Serializable {

	private static final long	serialVersionUID	= 1L;
	@SequenceGenerator(name = "PAY_SEQ_GEN", sequenceName = "PAY_SEQ",
			initialValue = 1)
	@Id
	@GeneratedValue(generator = "PAY_SEQ_GEN")
	@Column(name = "PAY_ID", unique = true, nullable = false)
	private long							paymentId;
	@Column(name = "CREDIT_NAME", nullable = false)
	private String						creditName;
	@Column(name = "CREDIT_NUM", nullable = false)
	private long							creditNum;
	@Column(name = "EXP", nullable = false)
	private int								expiration;
	@ManyToOne
	@JoinColumn(name = "PAY_ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
	private Account						userAccount;
	private Address						billing;

	public long getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public String getName() {
		return this.creditName;
	}

	public void setName(String name) {
		this.creditName = name;
	}

	public long getCreditNum() {
		return this.creditNum;
	}

	public void setCreditNum(long creditNum) {
		this.creditNum = creditNum;
	}

	public int getExpiration() {
		return this.expiration;
	}

	public void setExpiration(int expiration) {
		this.expiration = expiration;
	}

	public Address getBilling() {
		return this.billing;
	}

	public void setBilling(Address billing) {
		this.billing = billing;
	}

	public Account getUseraccount() {
		return this.userAccount;
	}

	public void setUseraccount(Account user) {
		this.userAccount = user;
	}

}
