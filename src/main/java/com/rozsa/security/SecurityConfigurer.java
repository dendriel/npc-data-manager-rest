package com.rozsa.security;

import com.rozsa.security.filters.*;
import lombok.AllArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    private final PreFlightFilter preFlightFilter;
    private final AuthFilter authFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
            .authorizeRequests()
                .antMatchers("/actuator/health")
                    .permitAll()
//                .anyRequest()
//                    .authenticated()
            .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(preFlightFilter, AuthFilter.class);
    }
}
