package com.mvlbarcelos.movie;

import com.mvlbarcelos.movie.Movie.TypeSubscription;
import com.mvlbarcelos.movie.user.UserClient;
import com.mvlbarcelos.movie.user.UserSubscription;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

	private final MovieRepository repository;

	private final UserClient userClient;

	public List<Movie> list(String username) {

		UserSubscription userSubscription = userClient.getSubscription(username);
		TypeSubscription subscription = userSubscription.getSubscription().getTypeSubscription();
		return repository.findByTypeSubscription(subscription);
	}
}
