package com.ecommerce.backend.security;

import org.springframework.boot.security.autoconfigure.web.servlet.SecurityFilterProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class EcommercePortalSecurityConfig {
    @Bean
    SecurityFilterChain customSecurityFilterChain(HttpSecurity http) {
        return http.csrf(csrfConfig->csrfConfig.disable())
                .authorizeHttpRequests((requests) ->
                        requests.requestMatchers(RegexRequestMatcher.regexMatcher(".*public$")).permitAll())

//                        requests.requestMatchers("/api/users/public").permitAll()
//                                .requestMatchers("/api/products/public").permitAll())
                        .formLogin(withDefaults())
                                .httpBasic(withDefaults())
                                        .build();
    }
}
