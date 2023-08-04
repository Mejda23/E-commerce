package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.SignUpDto;
import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.service.User.UserService;
@RestController
public class SignUpController {
	
	@Autowired
	private UserService userService;
	@PostMapping("/sign-up")
	public ResponseEntity<?> signupUser(@RequestBody SignUpDto signupDTO)
	{	if (userService.hasUserWithEmail(signupDTO.getemail()))
		{
		return new ResponseEntity<>("User already Exists",HttpStatus.NOT_ACCEPTABLE);
		}
		UserDto createdUser = userService.createUser(signupDTO);
		if (createdUser==null)
		{
			return new ResponseEntity<>("user not created ! ",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
	}
	
}
