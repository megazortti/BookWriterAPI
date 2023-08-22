// package com.api.controller;

// import org.springframework.boot.web.servlet.error.ErrorController;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import jakarta.servlet.http.HttpServletRequest;

// @RestController
// public class CustomErrorHandlingController implements ErrorController{
//     @RequestMapping("/error")
//     public ResponseEntity<?> HandleTheError(HttpServletRequest request) {
//         return new ResponseEntity<>("Something went wrong. ", HttpStatus.BAD_REQUEST);
//     }
// }