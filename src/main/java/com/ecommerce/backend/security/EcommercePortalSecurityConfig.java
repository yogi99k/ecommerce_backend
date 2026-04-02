package com.ecommerce.backend.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class EcommercePortalSecurityConfig {

    @Qualifier("publicPaths")
    private final List<String> publicPaths;

    @Qualifier("securedPaths")
    private final List<String> securedPaths;

    @Bean
    SecurityFilterChain customSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrfConfig -> csrfConfig.disable())
                .authorizeHttpRequests(requests -> {
                    publicPaths.forEach(path -> requests.requestMatchers(path).permitAll());
                    securedPaths.forEach(path -> requests.requestMatchers(path).authenticated());
                    requests.anyRequest().denyAll();
                })
//                        .requestMatchers(RegexRequestMatcher.regexMatcher(".*/public$")).permitAll()
//                        .requestMatchers(RegexRequestMatcher.regexMatcher(".*/v3/api-docs(?:/.*)?$")).permitAll()
//                        .requestMatchers(RegexRequestMatcher.regexMatcher(".*/swagger-ui(?:/.*)?$")).permitAll()
//                        .requestMatchers(RegexRequestMatcher.regexMatcher(".*/swagger-ui\\.html$")).permitAll()
//                        .anyRequest().authenticated()
//
//                        requests.requestMatchers("/api/users/public").permitAll()
//                                .requestMatchers("/api/products/public").permitAll())
//                )
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .build();
    }
}