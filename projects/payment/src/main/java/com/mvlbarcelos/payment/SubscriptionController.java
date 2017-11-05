package com.mvlbarcelos.payment;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class SubscriptionController {
	
	private final SubscriptionRepository repository;
	
	@PostMapping("/")
	public ResponseEntity<Subscription> create(@RequestBody Subscription subscription) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(subscription));
	}
	
	@GetMapping("/{username}")
	public Subscription getSubscription(@PathVariable String username) {
		return repository.findByUsername(username);
	}
}
