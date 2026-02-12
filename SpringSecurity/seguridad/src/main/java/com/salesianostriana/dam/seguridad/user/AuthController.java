package com.salesianostriana.dam.seguridad.user;

import com.salesianostriana.dam.seguridad.security.jwtAccessToken.JwtAccessTokenService;
import com.salesianostriana.dam.seguridad.user.dto.LoginRequest;
import com.salesianostriana.dam.seguridad.user.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserDetailsService userService;
    private final JwtAccessTokenService jwtService;
    private final AuthenticationManager authManager;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> doLogin (@RequestBody LoginRequest request){
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(), request.password())
        );

        String token = jwtService.generateAccessToken(request.username());
        return ResponseEntity.status(201).body(new LoginResponse(request.username(), token));
    }

}
