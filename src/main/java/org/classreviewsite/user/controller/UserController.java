package org.classreviewsite.user.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.classreviewsite.auth.jwt.JwtTokenProvider;
import org.classreviewsite.user.service.UserService;
import org.classreviewsite.user.dto.CreateUserRequest;
import org.classreviewsite.user.dto.LoginUserRequest;
import org.classreviewsite.user.dto.CreateUserResponse;
import org.classreviewsite.user.dto.LoginUserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {

   private final UserService userService;

   private final JwtTokenProvider jwtTokenProvider;

    /**
     * 로그인
     */
    @PostMapping("/signin")
    public Result signIn(@RequestBody LoginUserRequest dto){

        log.info("로그인: {}", dto);

//        try{
            LoginUserResponse response = userService.findByUserNumberAndPassword(dto);
            String token = jwtTokenProvider.generateToken(String.valueOf(response.getUser().getUserNumber()));
            response.setToken(token);
            return new Result<>(response);

//        }catch (NullPointerException e){
//            LoginUserResponse response = new LoginUserResponse(401, null, e.getMessage());
//            return new Result<>(response);
//        }catch (IllegalStateException e){
//            LoginUserResponse response = new LoginUserResponse(402, null, e.getMessage());
//            return new Result<>(response);
//        }

    }



    /**
     * 회원가입
     */
    @PostMapping("/signup")
    public Result signUp(@RequestBody CreateUserRequest dto){
        log.info("회원가입: {}" , dto);

//        try{


        CreateUserResponse response = userService.signUp(dto);
        return new Result<>(response);


//        }catch (IllegalArgumentException e){
//        CreateUserResponse response = new CreateUserResponse(401, null, e.getMessage());
//        return new Result<>(response);
//        }

    }



    @GetMapping("/test")
    public Result test(){
        userService.testResponse();
        return new Result<>("test");
    }




    @Data
    @AllArgsConstructor
    class Result<T>{
        private T data;
    }




}
