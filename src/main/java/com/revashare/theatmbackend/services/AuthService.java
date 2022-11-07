package com.revashare.theatmbackend.services;

import com.revashare.theatmbackend.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class AuthService {
    private final String SIGNING_KEY = "super-secret";
    private final Long HOUR = (1000L * 60 * 60);
    private final Long DAY = HOUR * 24;

    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token).getBody();
    }
    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }
    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, User user){
        String username = extractEmail(token);
        //need to compare this^ to what is in the DB
        return (!isTokenExpired(token) && username.equals(user.getEmail()));
    }

    public String generateToken(User user){
        Map<String, Object> claims = new HashMap<>();
        return generateToken(claims, user.getEmail());
    }

    private String generateToken(Map<String, Object> claims, String subject){
        return Jwts.builder().setClaims(claims)
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis()+(HOUR * 24)))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
                .compact();
    }
}
