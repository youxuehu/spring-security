package com.gq.web.controller;
  

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gq.dto.User;

@RestController
public class UserController {

	@GetMapping("/me")
	public Object getCurrentUser(@AuthenticationPrincipal UserDetails userDetails){
		return userDetails;
	}

	@RequestMapping(value="/user",method=RequestMethod.GET)
	public List<User> query(String userName){
		System.out.println(userName);
		List<User> users = new ArrayList<User>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users;
	}
}
