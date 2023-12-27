package com.jwt.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import static com.jwt.domain.Permission.*;
import static org.springframework.http.HttpMethod.*;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(req ->
                req
                .requestMatchers("/api/v1/public","/api/v1/auth/**").permitAll()
                .requestMatchers(GET,"/api/v1/admin").hasAuthority(ADMIN_READ.getPermission())
                .requestMatchers(POST,"/api/v1/admin").hasAuthority(ADMIN_CREATE.getPermission())
                .requestMatchers(DELETE,"/api/v1/admin").hasAuthority(ADMIN_DELETE.getPermission())
                .requestMatchers(POST,"/api/v1/admin/update").hasAuthority(ADMIN_UPDATE.getPermission())
                .requestMatchers(GET,"/api/v1/user").hasAnyAuthority(USER_READ.getPermission(),ADMIN_READ.getPermission())
                .requestMatchers(POST,"/api/v1/user").hasAnyAuthority(USER_CREATE.getPermission(),ADMIN_CREATE.getPermission())
                .requestMatchers(DELETE,"/api/v1/user").hasAnyAuthority(USER_DELETE.getPermission(),ADMIN_DELETE.getPermission())
                .requestMatchers(POST,"/api/v1/user/update").hasAnyAuthority(USER_UPDATE.getPermission(),ADMIN_UPDATE.getPermission())
                .anyRequest()
                .authenticated()
            )
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
    
}
