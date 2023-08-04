package com.example.ecommerce.service.User;

import com.example.ecommerce.dto.SignUpDto;
import com.example.ecommerce.dto.UserDto;

public interface UserService {

	public UserDto createUser(SignUpDto signupDTO);

	public boolean hasUserWithEmail(String getemail);

}
