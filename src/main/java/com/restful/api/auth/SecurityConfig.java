//package com.restful.api.auth;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
///**
// * @author Damiano Alves on 21/02/19
// * damiano.alves@gmail.com
// */
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf().disable().authorizeRequests()
//                .antMatchers("/home").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/login").permitAll()
//                .anyRequest().authenticated()
//                .and()
//
//                // filtra requisições de login
//                .addFilterBefore(new LoginFilter("/api/login", authenticationManager()),
//                        UsernamePasswordAuthenticationFilter.class)
//
//                // filtra outras requisições para verificar a presença do JWT no header
//                .addFilterBefore(new AuthenticationFilter(),
//                        UsernamePasswordAuthenticationFilter.class);
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // cria uma conta default
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("admin")
//                .roles("ADMIN");
//    }
//}