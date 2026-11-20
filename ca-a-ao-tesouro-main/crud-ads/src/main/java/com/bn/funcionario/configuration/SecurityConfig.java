package com.bn.funcionario.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/funcionarios").permitAll()
                        .requestMatchers(HttpMethod.POST, "/funcionarios").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/funcionarios").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/funcionarios").authenticated()
                        .anyRequest().denyAll()
                );
        return http.build();
    }
}