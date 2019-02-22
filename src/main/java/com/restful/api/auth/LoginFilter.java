//package com.restful.api.auth;
//
//import java.io.IOException;
//import java.error.Collections;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.error.matcher.AntPathRequestMatcher;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
///**
// * @author Damiano Alves on 21/02/19
// * damiano.alves@gmail.com
// */
//
//public class LoginFilter extends AbstractAuthenticationProcessingFilter {
//
//    protected LoginFilter(String url, AuthenticationManager authManager) {
//        super(new AntPathRequestMatcher(url));
//        setAuthenticationManager(authManager);
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
//            throws AuthenticationException, IOException, ServletException {
//
//        AccountCredentials credentials = new ObjectMapper()
//                .readValue(request.getInputStream(), AccountCredentials.class);
//
//        return getAuthenticationManager().authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        credentials.getUsername(),
//                        credentials.getPassword(),
//                        Collections.emptyList()
//                )
//        );
//    }
//
//    @Override
//    protected void successfulAuthentication(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            FilterChain filterChain,
//            Authentication auth) throws IOException, ServletException {
//
//        SecurityService.addAuthentication(response, auth.getName());
//    }
//
//}