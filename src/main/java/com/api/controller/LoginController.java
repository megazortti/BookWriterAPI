package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.UserAuthenticationDTO;
import com.api.entity.User;
import com.api.service.JwtService;
import com.api.service.UserService;
import com.api.service.UserServiceImpl;

import io.swagger.models.Response;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@RestController
public class LoginController {
    private final UserService userService;
    private final JwtService jwtService;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Autowired
    public LoginController(UserService userSerivce, JwtService jwtService) {
        this.userService = userSerivce;
        this.jwtService  = jwtService;
    }

    @GetMapping("/get-token")
    public ResponseEntity<String> getTokenFromSession(HttpSession session) {
        String token = (String) session.getAttribute("auth");
        
        return ResponseEntity.ok(token != null ? "Token from session: " + token : "Token not found in session");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(UserAuthenticationDTO userAuthenticationDTO, HttpSession httpSession) {
        User user = userService.findByMail(userAuthenticationDTO.getMail());
        Boolean matches = passwordEncoder.matches(userAuthenticationDTO.getPassword(), user.getPassword());
        if(matches){
            httpSession.setAttribute("auth", jwtService.generateToken(user.getMail()));
        }

        return new ResponseEntity<String>(matches ? "Access Granteed. Token is:" + httpSession.getAttribute("auth") : "Doesnt Matches", HttpStatus.OK);
    }
}
