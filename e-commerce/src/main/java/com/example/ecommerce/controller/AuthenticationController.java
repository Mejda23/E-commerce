package com.example.ecommerce.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.ecommerce.dto.AuthenticationRequest;
import com.example.ecommerce.dto.AuthenticationResponse;
import com.example.ecommerce.entities.User;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.service.User.UserService;
import com.example.ecommerce.service.util.JwtUtil;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthenticationController {
	public static final String TOKEN_PREFIX="Bearer ";
	public static final String HEADER_STRING="Authorization ";

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService UserDetailsService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/authenticate")
    public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws BadCredentialsException,DisabledException,UsernameNotFoundException ,IOException, ServletException{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getname(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect username or password.");
        } catch (DisabledException disabledException) {
            response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "User is not activated");
            return ;
        }

       final UserDetails userDetails = UserDetailsService.loadUserByUsername(authenticationRequest.getname());
       User user= userRepository.findFirstByemail(authenticationRequest.getname());
       final String jwt=jwtUtil.generateToken(authenticationRequest.getname());
       
       
       JSONObject jsonObject = new JSONObject();
       jsonObject.put("userId", user.getId());
       jsonObject.put("role", user.getUserRole().toString());

       // Write the JSON response to the HttpServletResponse
       response.getWriter().write(jsonObject.toString());

    	response.addHeader("Access-Control-Expose-Headers", "Authorization");
    	response.addHeader("Access-Control-Allow-Headers", "Authorization, X-PINGOTHER, Origin,X-Requested-With, Content-Type,Accept,X-Custom");
    	response.addHeader(HEADER_STRING, TOKEN_PREFIX+jwt);
    }
}