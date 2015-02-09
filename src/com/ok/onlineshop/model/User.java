package com.ok.onlineshop.model;

public class User {

	private long		userid;
	private String	username;
	private String	password;
	private String	email;
	private boolean	status;

	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.status = false;
	}

	@Override
	public String toString() {
		return "User [username=" + this.username + ", password=" + this.password
				+ ", email=" + this.email + ", status=" + this.status + "]";
	}

	public String getusername() {
		return this.username;
	}

	public void setusername(String username) {
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

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
}
