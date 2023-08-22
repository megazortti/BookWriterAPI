package com.api.interceptor;

import com.api.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    private final JwtService jwtService;

    @Autowired
    public JwtInterceptor(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String token = "test";
        return true;

        // if (jwtService.isTokenValid(token)) {
        //     // Token is valid, proceed with the request
        //     return true;
        // } 
        // else {
        //     // Token is invalid, send unauthorized response
        //     response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        //     return false;
        // }
    }
}