package com.gq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired private RedisTemplate redisTemplate;
	@GetMapping("/hello")
	public String hello() {
		System.out.println(redisTemplate);
		SetOperations set = redisTemplate.opsForSet();
		set.add("name","jack");
		return "hello spring security";
	}
}
			