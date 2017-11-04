package com.mvlbarcelos.movie;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mvlbarcelos.movie.Movie.Subscription;

public interface MovieRepository extends PagingAndSortingRepository<Movie, UUID> {
	
	List<Movie> findBySubscription(Subscription subscription);
	  

}
