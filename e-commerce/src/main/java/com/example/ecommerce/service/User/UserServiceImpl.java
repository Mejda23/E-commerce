package com.example.ecommerce.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.SignUpDto;
import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.entities.User;
import com.example.ecommerce.enums.UserRole;
import com.example.ecommerce.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDto createUser(SignUpDto signupDTO) {
	User user=new User();
	user.setName(signupDTO.getName());
	user.setemail(signupDTO.getemail());
	user.setUserRole(UserRole.USER);
	user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));
	User createdUser=userRepository.save(user);
	UserDto userDto=new UserDto();
	userDto.setId(createdUser.getId());
	userDto.setName(createdUser.getName());
	userDto.setemail(createdUser.getemail());
	userDto.setUserRole(createdUser.getUserRole());

	return userDto;}

	@Override
	public boolean hasUserWithEmail(String email) {
		return userRepository.findFirstByemail(email)!=null;
}

	
}
