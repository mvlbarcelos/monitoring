package com.mvlbarcelos.payment;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "subscription")
@Data
public class SubscriptionConfigurationProperties {
    private boolean initDb = true;
}
