package com.demo.contactmanagement.persisted;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Generated Jan 28, 2015 1:37:42 PM by Hibernate Tools 3.4.0.CR1

/**
 * User generated by hbm2java
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements java.io.Serializable {

	private Integer id;
	private String username;
	private String password;
	private int role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

}