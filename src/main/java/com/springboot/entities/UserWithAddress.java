package com.springboot.entities;

import java.io.Serializable;

/**
 * The persistent class for the users database table.
 * 
 */
public class UserWithAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String password;

	private String username;

	private String address;

	public UserWithAddress() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserWithAddress [id=" + id + ", password=" + password + ", username=" + username + ", address=" + address + "]";
	}

}