package com.mvlbarcelos.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@GetMapping("/users/{username}")
	public User find(@PathVariable String username) {
		return repository.findOne(username);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> create(@RequestBody User user) {
		return new ResponseEntity<User>(repository.save(user), HttpStatus.CREATED);
	}
	
}
