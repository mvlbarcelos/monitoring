package com.mvlbarcelos.user.payment;

import com.mvlbarcelos.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserSubscription {

	private User user;
	private Subscription subscription;

}
