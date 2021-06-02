package com.rozsa.service.api;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {
    UserDetails validate(String token);
}
