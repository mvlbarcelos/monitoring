package com.mvlbarcelos.movie;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MovieController {
	
	private final MovieRepository repository;
	
	private final MovieService service;
	
	@PostMapping("/")
	public ResponseEntity<Movie> create(@RequestBody Movie movie) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(movie));
	}
	
	@GetMapping("/")
	public List<Movie> listBySubcription(@RequestHeader("Username") String username){
		return service.list(username);
	}
	
}
