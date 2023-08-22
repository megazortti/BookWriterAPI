package com.api.service;

public interface JwtService {
    String extractSubjectFromToken(String token);
    String generateToken(String subject);
    boolean isTokenValid(String token);
}
