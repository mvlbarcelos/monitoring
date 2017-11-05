package com.mvlbarcelos.movie;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "movie")
@Data
public class MovieConfigurationProperties {
    private boolean initDb = true;
}
