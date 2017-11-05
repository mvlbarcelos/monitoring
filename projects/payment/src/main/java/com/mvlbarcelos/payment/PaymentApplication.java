package com.mvlbarcelos.payment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@EnableConfigurationProperties(SubscriptionConfigurationProperties.class)
public class PaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}
	
	@Bean
	public AlwaysSampler defaultSampler() {
	  return new AlwaysSampler();
	}

	@Bean
	public CommandLineRunner initDb(SubscriptionConfigurationProperties subscriptionConfigurationProperties,
									SubscriptionRepository subscriptionRepository) {
		if (!subscriptionConfigurationProperties.isInitDb()) {
			return null;
		} else {
			return strings -> Stream.of(new Subscription("marcus", Subscription.Type.PREMIUM, Subscription.Status.ACTIVE),
					new Subscription("jonh", Subscription.Type.PREMIUM, Subscription.Status.ACTIVE),
					new Subscription("paul", Subscription.Type.STANDARD, Subscription.Status.ACTIVE)).forEach(
					m -> subscriptionRepository.save(m)
			);
		}
	}
}
