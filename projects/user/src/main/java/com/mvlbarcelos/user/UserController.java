package com.mvlbarcelos.user;

import com.mvlbarcelos.user.payment.PaymentClient;
import com.mvlbarcelos.user.payment.UserSubscription;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

	private final UserRepository repository;
	
	private final PaymentClient paymentClient;
	
	@GetMapping("/{username}")
	public User find(@PathVariable String username) {
		return repository.findOne(username);
	}
	
	@PostMapping("/")
	public ResponseEntity<User> create(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(user));
	}
	
	@GetMapping("/{username}/subscription")
	public UserSubscription getUserSubscription(@PathVariable String username) {
		return paymentClient.userSubscription(username);
	}
	
	
}
