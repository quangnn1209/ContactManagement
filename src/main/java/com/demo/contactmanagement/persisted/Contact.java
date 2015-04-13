package com.demo.contactmanagement.persisted;

// Generated Jan 30, 2015 10:35:04 AM by Hibernate Tools 3.4.0.CR1

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Contact generated by hbm2java
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact implements java.io.Serializable {
	private Integer id;
	private String firstName;
	private String lastName;
	private String mobile;
	private String email;

	public Contact(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}