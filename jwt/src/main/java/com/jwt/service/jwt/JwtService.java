package com.jwt.service.jwt;

import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;

public interface JwtService {
    
    String extractUsername(String token);
    String generateToken(Map<String,Object> extractClaims,UserDetails userDetails);
    String generateToken(UserDetails userDetails);
    <T> T extractClaims(String token,Function<Claims,T> claimsResolver);
    Boolean isTokenValid(String token, UserDetails userDetails);
}
