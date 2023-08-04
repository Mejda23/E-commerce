package com.example.ecommerce.dto;

public class SignUpDto {
	private String name;
	private String Password;

	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		email = email;
	}
}
