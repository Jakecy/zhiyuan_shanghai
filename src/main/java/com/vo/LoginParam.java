package com.vo;

import java.io.Serializable;

public class LoginParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8155895241067400670L;
	
	
	private String username;
	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
