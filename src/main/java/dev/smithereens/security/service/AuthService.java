package dev.smithereens.security.service;

import dev.smithereens.security.dto.TokenRequest;
import dev.smithereens.security.dto.TokenResponse;
import dev.smithereens.security.security.JwtTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;

    private final JwtTokenService tokenService;

    private final AuthenticationManager authenticationManager;

    public TokenResponse login(TokenRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userService.getByUsername(request.getUsername()).orElseThrow();
        var token = tokenService.generateToken(user);
        return new TokenResponse(token);
    }
}
