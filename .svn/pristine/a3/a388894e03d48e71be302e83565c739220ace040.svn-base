package com.ok.onlineshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

	private static final long	serialVersionUID	= 1L;
	@SequenceGenerator(name = "USER_SEQ_GEN", sequenceName = "USER_SEQ",
			initialValue = 1)
	@Id
	@GeneratedValue(generator = "USER_SEQ_GEN")
	@Column(name = "USERID", unique = true, nullable = false)
	private BigDecimal				userid;
	@Column(name = "USERNAME", unique = true, nullable = false)
	private String						username;
	@Column(name = "PASS", nullable = false)
	private String						password;
	@Column(name = "EMAIL", unique = true, nullable = false)
	private String						email;
	@Column(name = "REGISTRATION_DATE")
	private Date							registrationDate;
	transient private boolean	status;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_ID")
	private Account						accountInfo;

	public BigDecimal getUserid() {
		return this.userid;
	}

	public void setUserid(BigDecimal userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Account getAccountInfo() {
		return this.accountInfo;
	}

	public void setAccountInfo(Account accountInfo) {
		this.accountInfo = accountInfo;
	}

	@Override
	public String toString() {
		return "User [userid=" + this.userid + ", username=" + this.username
				+ ", password=" + this.password + ", email=" + this.email
				+ ", registrationDate=" + this.registrationDate + ", accountId="
				+ this.accountInfo.getAccountId().toString() + "]";
	}

}
