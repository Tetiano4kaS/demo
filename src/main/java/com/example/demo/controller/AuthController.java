package com.example.demo.controller;

import com.example.demo.dto.JwtRequest;
import com.example.demo.dto.JwtResponse;
import com.example.demo.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    @PostMapping("/cars/singin")
    public ResponseEntity<JwtResponse> signIn(@RequestBody JwtRequest jwtRequest) {
        Authentication authentication = UsernamePasswordAuthenticationToken
                .unauthenticated(jwtRequest.getUsername(), jwtRequest.getPassword());
        authenticationManager.authenticate(authentication);

        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = jwtService.generateToken(userDetails);
        JwtResponse response = new JwtResponse();
        response.setToken(token);

        return ResponseEntity.ok(response);

    }
}
