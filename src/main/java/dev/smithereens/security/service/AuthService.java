package dev.smithereens.security.service;

import dev.smithereens.security.dto.TokenRequest;
import dev.smithereens.security.dto.TokenResponse;
import dev.smithereens.security.mapper.UserMapper;
import dev.smithereens.security.security.JwtTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;

    private final JwtTokenService tokenService;

    //    private final AuthenticationManager authenticationManager;

    private final UserMapper userMapper;

    public TokenResponse login(TokenRequest request) {
        //        authenticationManager.authenticate(
        //                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userService.getByUsername(request.getUsername()).orElseThrow();
        var token = tokenService.generateToken(user);
        return new TokenResponse(token);
    }

    public TokenResponse register(TokenRequest request) {
        var user = userMapper.fromTokenRequestToUser(request);
        userService.save(user);
        var token = tokenService.generateToken(user);
        return new TokenResponse(token);
    }
}
