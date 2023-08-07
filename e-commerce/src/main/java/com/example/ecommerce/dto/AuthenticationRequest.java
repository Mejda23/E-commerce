package com.example.ecommerce.dto;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {
private String name;
private String password;
public String getname() {
	return name;
}
public void setname(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}    public AuthenticationRequest(String name, String password) {
    this.setname(name);
    this.setPassword(password);
}


}