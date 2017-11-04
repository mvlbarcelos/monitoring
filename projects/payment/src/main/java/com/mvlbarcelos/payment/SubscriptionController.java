package com.mvlbarcelos.payment;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionController {
	
	@Autowired
	private SubscriptionRepository repository;
	
	@PostMapping("/")
	public ResponseEntity<Subscription> create(@RequestBody Subscription subscription) {
		return new ResponseEntity<Subscription>(repository.save(subscription), HttpStatus.CREATED);
	}
	
	@GetMapping("/{username}")
	public Subscription getSubscription(@PathVariable String username) {
		return repository.findByUserUsername(username);
	}
}
