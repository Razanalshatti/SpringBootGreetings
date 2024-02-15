package com.letcode.SecureBankSystem.config;

import com.letcode.SecureBankSystem.bo.customUserDetails.CustomUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Component
public class JWTUtil {
    private final String jwtSignKey = "secret";
    public String generateToken(CustomUserDetails userDetails){
        return doGenerateToken(userDetails.getClaims(), userDetails.getUserName());
    }
    private String doGenerateToken(Map<String , Object>claims,String subject){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis())) // help us to calculate expiration date for token so we can know if token valid or not
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(24))) //toMillis means exact exact current time
                .signWith(SignatureAlgorithm.HS256, jwtSignKey).compact();
    }
    public <T> T getClaimsFromToken(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    private Claims getAllClaimsFromToken(String token){
        return Jwts.parser().setSigningKey(jwtSignKey).parseClaimsJws(token).getBody();
    }

    public Date getExpirationDateFromToken(String token){
        return getClaimsFromToken(token, Claims::getExpiration); // :: method reference
    }
    private boolean isTokenExpired(String token){
        Date tokenExpirationDate = getExpirationDateFromToken(token);
        return tokenExpirationDate.before(new Date());
    }
    public boolean isTokenValid(String token){
        try{
            return !isTokenExpired(token);
        }catch (Exception exception){
            return false;
        }
    }
    public String getUsernameFromToken(String token){
        return getClaimsFromToken(token, Claims::getSubject);
    }
}
