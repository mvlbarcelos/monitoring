package com.mvlbarcelos.payment;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface SubscriptionRepository extends PagingAndSortingRepository<Subscription, UUID> {
	
	Subscription findByUsername(String username);
}
