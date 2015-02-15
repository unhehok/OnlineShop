package com.ok.onlineshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Address implements Serializable {

	private static final long	serialVersionUID	= 1L;
	@Id
	@Column(name = "ADDRESS_ID", unique = true, nullable = false)
	private long							addressId;
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
	private int								addressType;						// equals 0 for BILLING, 1 for SHIPPING, 2 for BOTH

}
