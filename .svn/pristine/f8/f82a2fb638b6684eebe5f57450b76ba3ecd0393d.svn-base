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

@Entity(name = "ADDRESS")
public class Address implements Serializable {

	private static final long	serialVersionUID	= 1L;
	@SequenceGenerator(name = "ADD_SEQ_GEN", sequenceName = "ADD_SEQ",
			initialValue = 1)
	@Id
	@GeneratedValue(generator = "ADD_SEQ_GEN")
	@Column(name = "ADDRESS_ID", unique = true, nullable = false)
	private BigDecimal				addressId;
	@Column(name = "RECIPIENT", nullable = false)
	private String						recipient;
	@Column(name = "STREET1", nullable = false)
	private String						street1;
	@Column(name = "STREET2")
	private String						street2;
	@Column(name = "CITY", nullable = false)
	private String						city;
	@Column(name = "STATE", nullable = false)
	private String						state;
	@Column(name = "ZIP", nullable = false)
	private int								zip;
	@ManyToOne
	@JoinColumn(name = "ADDRESS_ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
	private Account						userAccount;

	public boolean validAddress() {
		boolean toRet = true;
		// validate address fields
		return toRet;
	}

	public BigDecimal getAddressId() {
		return this.addressId;
	}

	public void setAddressId(BigDecimal addressId) {
		this.addressId = addressId;
	}

	public String getRecipient() {
		return this.recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getStreet1() {
		return this.street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return this.street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return this.zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public Account getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(Account userAccount) {
		this.userAccount = userAccount;
	}

	public static long getSerialversionuid() {
		return Address.serialVersionUID;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + this.addressId + ", recipient="
				+ this.recipient + ", street1=" + this.street1 + ", street2="
				+ this.street2 + ", city=" + this.city + ", state=" + this.state
				+ ", zip=" + this.zip + ", userAccount=" + this.userAccount + "]";
	}

}
