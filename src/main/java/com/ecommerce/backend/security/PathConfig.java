package com.ecommerce.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PathConfig {

    @Bean("publicPaths")
    public List<String> publicPaths(){
        return List.of(
                "/api/users/public",
                "/api/products/public",
                "/api/swagger-ui.html",
                "/swagger-ui/**",
                "/api/v3/api-docs/**",
                "/swagger-resources/**",
                "/swagger-ui.html",
                "/webjars/**",
                "/swagger-ui/**",
                "/swagger-ui.html",
                "/v3/api-docs/**"
        );
    }

    @Bean("securePaths")
    public List<String> securePaths(){
        return List.of(
                "/api/**"
        );
    }
    @Bean(name = "securedPaths")
    public List<String> securedPaths() {
        return List.of(
                "/api/**"
        );
    }
}
