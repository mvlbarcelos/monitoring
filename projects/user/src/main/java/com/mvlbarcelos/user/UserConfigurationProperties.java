package com.mvlbarcelos.user;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "user")
@Data
public class UserConfigurationProperties {
    private boolean initDb = true;
}
