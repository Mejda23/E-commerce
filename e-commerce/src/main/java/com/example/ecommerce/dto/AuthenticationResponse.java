package com.example.ecommerce.dto;

public class AuthenticationResponse {
private String jwtToken;

public String getJwtToken() {
	return jwtToken;
}

public void setJwtToken(String jwtToken) {
	this.jwtToken = jwtToken;
}
public AuthenticationResponse(String jwt)
{}
}
