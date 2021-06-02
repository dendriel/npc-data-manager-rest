package com.rozsa.property;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource("classpath:auth.properties")
public class AuthProperties {

    @Value("${server.url}")
    private String serverAddress;
}
