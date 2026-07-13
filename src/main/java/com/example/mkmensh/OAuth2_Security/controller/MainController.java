package com.example.mkmensh.OAuth2_Security.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping("/greet")
    public ResponseEntity<String> greet() {
        return new ResponseEntity<>("Hello User", HttpStatus.ACCEPTED);
    }

    @GetMapping("/data")
    public ResponseEntity<Map<String, Integer>> getData() {
        Map<String, Integer> obj = new HashMap<>();
        obj.put("Mahmoud", 1);
        obj.put("7oda", 2);
        obj.put("MKM", 3);

        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @GetMapping("/me")
    public Object me(@AuthenticationPrincipal OidcUser user) {
        return user;
    }
}
