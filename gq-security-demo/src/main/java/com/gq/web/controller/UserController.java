package com.gq.web.controller;
  

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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
	@Autowired private RedisTemplate redisTemplate;
	@Autowired private ObjectMapper objectMapper;

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

	@RequestMapping("/redis")
	public Object writeData() throws JsonProcessingException {
		System.out.println(redisTemplate);
		/*List clientList = redisTemplate.getClientList();
		String json = objectMapper.writeValueAsString(clientList);
		System.out.println(json);*/
		ValueOperations valueOperations = redisTemplate.opsForValue();
		valueOperations.set("name","youxuehu");
		return redisTemplate;
	}



}
