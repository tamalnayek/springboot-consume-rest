package com.sample.consume.rest.model;

public class Authorized {

	private String username;
	private String password;
	
	public Authorized() {
		super();
		this.username = "bob@sb-pmi.com";
		this.password = "Veeva1234";
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		//this.username = username;
		this.username = "bob@sb-pmi.com";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		//this.password = password;
		this.password = "Veeva1234";
	}
	
	
}
