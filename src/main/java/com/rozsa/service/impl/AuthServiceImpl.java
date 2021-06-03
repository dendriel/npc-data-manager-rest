package com.rozsa.service.impl;

import com.rozsa.property.AuthProperties;
import com.rozsa.service.AuthService;
import com.rozsa.util.HeaderUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class AuthServiceImpl implements AuthService {
    private static final String VALIDATE_PATH = "/validate";

    private final WebClient webClient;

    public AuthServiceImpl(AuthProperties authProperties) {
        this.webClient = WebClient.create(authProperties.getServerAddress());
    }

    @Override
    public UserDetails validate(String token) {
        ClientResponse response = webClient.get()
                .uri(VALIDATE_PATH)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .exchange()
                .block();

        log.info("Validation status for token {} is {}", token, response.statusCode());

        if (!HttpStatus.OK.equals(response.statusCode())) {
            return null;
        }

        String username = HeaderUtil.getHeaderValues(response.headers().asHttpHeaders(), "x-ndm-username")
                .stream()
                .findFirst()
                .orElse(null);

        if (username == null) {
            return null;
        }

        List<GrantedAuthority> authorities = HeaderUtil.getHeaderValues(response.headers().asHttpHeaders(), "x-ndm-authorities")
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(username, "", authorities);
    }
}
