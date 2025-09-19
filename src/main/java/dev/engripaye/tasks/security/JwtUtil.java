package dev.engripaye.tasks.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key key;
    private final Long expiration;

    public JwtUtil(@Value("${jwt.secret}") String Secret,
                   @Value("${jwt.expiration-ms:86400000}") Long expirationMs) {
        this.key = Keys.hmacShaKeyFor(Secret.getBytes());
        this.expiration = expirationMs;
    }

    public String generateToken(String subjects){
        Date now = new Date();
        Date exp = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .setSubject(subjects)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(key)
                .compact();
    }


    public String extractSubject(String token){
        try{
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        }
        catch (Exception e){
            return null;
        }
    }
}
