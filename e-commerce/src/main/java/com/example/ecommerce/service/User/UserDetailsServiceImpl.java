package com.example.ecommerce.service.User;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entities.User;
import com.example.ecommerce.repository.UserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Override	
    public UserDetails  loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findFirstByemail(username);
        if (user == null)
            throw new UsernameNotFoundException("username " + username
                    + " not found",null);

        System.out.println("---------------------> FOUND ------------->"
                + user.getemail());

        return new org.springframework.security.core.userdetails.User(user.getemail(),user.getPassword(),new ArrayList<>());
    }
}
