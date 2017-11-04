package com.mvlbarcelos.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
	
	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private MovieService service;
	
	@PostMapping("/")
	public ResponseEntity<Movie> create(@RequestBody Movie movie) {
		return new ResponseEntity<Movie>(repository.save(movie), HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public List<Movie> listBySubcription(@RequestHeader("Username") String username){
		return service.list(username);
	}
	
}
