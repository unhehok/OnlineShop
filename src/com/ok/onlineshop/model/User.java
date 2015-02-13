package com.ok.onlineshop.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "USERS")
public class User implements Serializable {

	private static final long	serialVersionUID	= 1L;
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "USER_SEQ",
			allocationSize = 20)
	@Column(name = "USERID", nullable = false)
	private long							userid;
	@Column(name = "USERNAME")
	private String						username;
	@Column(name = "PASS")
	private String						password;
	@Column(name = "EMAIL")
	private String						email;
	@Column(name = "REGISTRATION_DATE")
	private Date							registrationDate;
	transient private boolean	status;

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
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

	@Override
	public String toString() {
		return "User [userid=" + this.userid + ", username=" + this.username
				+ ", password=" + this.password + ", email=" + this.email
				+ ", registrationDate=" + this.registrationDate + ", status="
				+ this.status + "]";
	}

}
