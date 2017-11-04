package com.mvlbarcelos.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mvlbarcelos.movie.Movie.Subscription;

@RestController
public class MovieController {
	
	@Autowired
	private MovieRepository repository;
	
	@PostMapping("/movies")
	public ResponseEntity<Movie> create(@RequestBody Movie movie) {
		return new ResponseEntity<Movie>(repository.save(movie), HttpStatus.CREATED);
	}
	
	@GetMapping("/movies/{subscription}")
	public List<Movie> listBySubcription(@PathVariable Subscription subscription){
		return repository.findBySubscription(subscription);
	}
	
}
