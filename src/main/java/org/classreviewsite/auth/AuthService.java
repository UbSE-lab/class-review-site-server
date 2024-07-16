package org.classreviewsite.auth;

import lombok.RequiredArgsConstructor;
import org.classreviewsite.auth.jwt.JwtTokenProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtTokenProvider jwtTokenProvider;


    public void valid(String token){
        jwtTokenProvider.isValidToken(token);
    }
}
