package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.Book;
import com.api.repository.BookRepository;
import com.api.repository.UserRepository;
import com.api.service.BookService;
import com.api.service.BookServiceImpl;
import com.api.service.JwtService;
import com.api.service.JwtServiceImpl;

@SpringBootApplication
@EntityScan("com.api.entity") // Make sure the package is correctly specified
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
        JwtService jwtService = new JwtServiceImpl();
        String subject = "exampleUser";
        String token = jwtService.generateToken(subject);
        System.out.println("Generated Token: " + token);

        // Extract subject from token
        String extractedSubject = jwtService.extractSubjectFromToken(token);
        System.out.println("Extracted Subject: " + extractedSubject);

        // Check token validity
        boolean isValid = jwtService.isTokenValid(token);
        System.out.println("Is Token Valid? " + isValid);

    }

}
