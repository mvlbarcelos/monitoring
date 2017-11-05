package com.mvlbarcelos.movie.user;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.Assert;

@ConfigurationProperties(prefix = "user")
@Data
public class UserConfigurationProperties implements InitializingBean {
    private String url;

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(url, "url must not be null");
    }
}
