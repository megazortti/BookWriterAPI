package com.api.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {

    private String SECRET_KEY = "yourSecretKey"; // Replace with your secret key
    private long EXPIRATION_TIME = 3600000; // 1 hour in milliseconds

    public String generateToken(String subject) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String extractSubjectFromToken(String token) {
        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token);

        Claims claims = claimsJws.getBody();
        return claims.getSubject();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
