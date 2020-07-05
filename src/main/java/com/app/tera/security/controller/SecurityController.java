package com.app.tera.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("com/app/tera/security")
public class SecurityController {

    @GetMapping("/access-denied")
    public ResponseEntity<String> accessDenied(){
        return new ResponseEntity<>("Access-Denied", HttpStatus.FORBIDDEN);
    }
}
