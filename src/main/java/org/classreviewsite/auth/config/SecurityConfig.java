//package org.classreviewsite.application.security;
//
//import lombok.RequiredArgsConstructor;
//import org.classreviewsite.auth.jwt.JwtTokenProvider;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecutiry
//@RequiredArgsConstructor
//public class SecurityConfig {
//
//    private final JwtTokenProvider jwtTokenProvider;
//
//
//    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity
//                .httpBasic().disable()
//                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .and()
//                .addFilterBefore(new JwtAUthenticationFilter(jwtTokenProvider), )
//    }
//
//}
