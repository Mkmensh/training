package com.example.mkmensh.OAuth2_Security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain addFilterChain(HttpSecurity http) throws Exception {

        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults())  // For user Name and password authentication
                .oauth2Login(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .build();
    }

    static int maxCardCount(int n, int[] card) {
        return dp(0, n, card, 1);
    }

    static int dp(int i, int n, int[] card, int sum) {
        if (i == n) {
            return 0;
        } else if (sum + card[i] >= 1) {
            return Math.max(dp(i +1, n, card, sum + card[i]), dp(i + 1, n, card, sum));
        } else {
            return dp(i + 1, n, card, sum);
        }
    }
}
