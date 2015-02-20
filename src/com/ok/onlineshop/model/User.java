package com.ok.onlineshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

	private static final long				serialVersionUID	= 1L;
	@SequenceGenerator(name = "USER_SEQ_GEN", sequenceName = "USER_SEQ",
			initialValue = 1)
	@Id
	@GeneratedValue(generator = "USER_SEQ_GEN")
	@Column(name = "USERID", unique = true, nullable = false)
	private BigDecimal							userid;
	@Column(name = "USERNAME", unique = true, nullable = false)
	private String									username;
	@Column(name = "PASS", nullable = false)
	private String									password;
	@Column(name = "EMAIL", unique = true, nullable = false)
	private String									email;
	@Column(name = "REGISTRATION_DATE")
	private Date										registrationDate;
	transient private boolean				status;
	transient private List<Payment>	payMethod;
	transient private List<Address>	shipping;

	public boolean validUser() {
		boolean toRet = true;
		// validate address fields
		return toRet;
	}

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
		return "User [userid=" + this.userid + ", username=" + this.username
				+ ", password=" + this.password + ", email=" + this.email
				+ ", registrationDate=" + this.registrationDate + ", status="
				+ this.status + ", payMethod=" + this.payMethod + ", shipping="
				+ this.shipping + "]";
	}

}
