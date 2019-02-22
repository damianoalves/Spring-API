//package com.restful.api.auth;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.error.Collections;
//import java.error.Date;
//
///**
// * @author Damiano Alves on 21/02/19
// * damiano.alves@gmail.com
// */
//
//public class SecurityService {
//
//    private static final String SECRET = "segredo";
//    private static final String TOKEN_PREFIX = "Bearer ";
//    private static final String HEADER_STRING = "Authorization";
//    private static final Long EXPIRATION_TIME = 86400000L;
//
//    static void addAuthentication(HttpServletResponse response, String username) {
//        String JWT = Jwts.builder()
//                .setSubject(username)
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(SignatureAlgorithm.HS512, SECRET)
//                .compact();
//
//        response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
//    }
//
//    static Authentication getAuthentication(HttpServletRequest request) {
//        String token = request.getHeader(HEADER_STRING);
//
//        if (token != null) {
//            String user = Jwts.parser()
//                    .setSigningKey(SECRET)
//                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
//                    .getBody()
//                    .getSubject();
//
//            if (user != null) {
//                return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
//            }
//        }
//        return null;
//    }
//
//}