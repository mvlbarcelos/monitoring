package com.mvlbarcelos.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvlbarcelos.movie.Movie.TypeSubscription;
import com.mvlbarcelos.movie.user.UserClient;
import com.mvlbarcelos.movie.user.UserSubscription;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	@Autowired
	private UserClient userClient;

	public List<Movie> list(String username) {

		UserSubscription userSubscription = userClient.getSubscription(username);
		TypeSubscription subscription = userSubscription.getSubscription().getTypeSubscription();
		return repository.findByTypeSubscription(subscription);
	}
}
