package com.salesianostriana.dam.seguridad.security.jwtAccessToken;

import com.salesianostriana.dam.seguridad.user.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;

@Service
public class JwtAccessTokenService {

    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.duration}")
    private long jwtLifeInSeconds;

    private JwtParser jwtParser;

    private SecretKey secretKey;

    @PostConstruct
    public void init() {

        secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        jwtParser = Jwts.parser()
                .verifyWith(secretKey)
                .build();

    }

    public String generateAccessToken(User user) {
        return generateAccessToken(user.getUsername());
    }

    public String generateAccessToken(String username) {
        return Jwts.builder()
                .header().setType(TOKEN_TYPE)
                .and()
                .subject(username)
                .issuedAt(new Date())
                .expiration(Date.from(
                        Instant.now()
                                .plusSeconds(jwtLifeInSeconds)
                ))
                .signWith(secretKey)
                .compact();
    }

    public boolean validateAccessToken(String token) throws JwtException {
        jwtParser.parseSignedClaims(token);
        return true;
    }

    public String getUsernameFromAccessToken(String token) {
        return jwtParser
                .parseSignedClaims(token)
                .getBody()
                .getSubject();
    }


}
