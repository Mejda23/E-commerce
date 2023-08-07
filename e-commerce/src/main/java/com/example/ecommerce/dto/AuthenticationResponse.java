package com.example.ecommerce.dto;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {
private String jwtToken;

public String getJwtToken() {
	return jwtToken;
}

public void setJwtToken(String jwtToken) {
	this.jwtToken = jwtToken;
}
public AuthenticationResponse(String jwt)
{this.jwtToken=jwt;}
}