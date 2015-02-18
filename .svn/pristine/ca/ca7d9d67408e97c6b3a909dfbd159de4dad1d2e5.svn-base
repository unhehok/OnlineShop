package com.ok.onlineshop.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "PAYMENT")
public class Payment implements Serializable {

	private static final long	serialVersionUID	= 1L;
	@SequenceGenerator(name = "PAY_SEQ_GEN", sequenceName = "PAY_SEQ",
			initialValue = 1)
	@Id
	@GeneratedValue(generator = "PAY_SEQ_GEN")
	@Column(name = "PAY_ID", unique = true, nullable = false)
	private BigDecimal				paymentId;
	@Column(name = "CREDIT_NAME", nullable = false)
	private String						creditName;
	@Column(name = "CREDIT_NUM", nullable = false)
	private long							creditNum;
	@Column(name = "EXP", nullable = false)
	private int								expiration;
	@ManyToOne
	@JoinColumn(name = "PAY_ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
	private Account						userAccount;
	@OneToOne
	@JoinColumn(name = "ADDRESS_ID")
	private Address						billing;

	public BigDecimal getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(BigDecimal paymentId) {
		this.paymentId = paymentId;
	}

	public String getCreditName() {
		return this.creditName;
	}

	public void setCreditName(String name) {
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

	public Account getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(Account user) {
		this.userAccount = user;
	}

	public boolean validPayment() {
		boolean toRet = true;
		// if ((StringUtils.countMatches(this.creditName, " ") != 1)) {
		// toRet = false;
		// }
		// System.out.println("creditNum = " + creditNum + "; # of digits = "
		// + (long) Math.log10(this.creditNum) + 1);
		return toRet;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + this.paymentId + ", creditName="
				+ this.creditName + ", creditNum=" + this.creditNum + ", expiration="
				+ this.expiration + ", userAccount=" + this.userAccount + ", billing="
				+ this.billing + "]";
	}

}
