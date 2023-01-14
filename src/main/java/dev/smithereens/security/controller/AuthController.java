package dev.smithereens.security.controller;

import dev.smithereens.security.dto.TokenRequest;
import dev.smithereens.security.dto.TokenResponse;
import dev.smithereens.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody TokenRequest tokenRequest) {
        return ResponseEntity.ok(authService.login(tokenRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<TokenResponse> register(@RequestBody TokenRequest tokenRequest) {
        return ResponseEntity.ok(authService.register(tokenRequest));
    }
}
