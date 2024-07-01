package org.classreviewsite.user.service;

import lombok.extern.slf4j.Slf4j;
import org.classreviewsite.user.dto.CreateUserRequest;
import org.classreviewsite.user.dto.LoginUserRequest;
import org.classreviewsite.user.dto.CreateUserResponse;
import org.classreviewsite.user.dto.LoginUserResponse;
import org.classreviewsite.data.User;
import org.classreviewsite.auth.exception.UserExistException;
import org.classreviewsite.auth.exception.UserNotFoundException;
import org.classreviewsite.auth.exception.UserNumberLimitException;
import org.classreviewsite.user.infrastructure.UserDataRepository;
import org.classreviewsite.user.infrastructure.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional(readOnly = true)
public class UserService {

    UserRepository userRepository;

    private final UserDataRepository userDataRepository;

    public UserService(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(Long userNumber){
        return userDataRepository.findById(userNumber);
    }


    @Transactional
    public CreateUserResponse signUp(CreateUserRequest user){

        validateDuplicateUser(user);

        User savedUser = User.builder()
            .userNumber(user.getUserNumber())
            .userName(user.getUserName())
            .department(user.getDepartment())
            .nickname(user.getNickname())
            .password(user.getPassword())
            .build();


        userDataRepository.save(savedUser);

        return new CreateUserResponse(200, savedUser, "회원가입이 완료되었습니다.");
    }


    @Transactional(readOnly = true)
    private void validateDuplicateUser(CreateUserRequest user){

       userDataRepository.findByUserNumber(user.getUserNumber())
               .ifPresent(m -> {
            throw new UserExistException("이미 존재하는 학생입니다.");
        });


    }


    @Transactional(readOnly = true)
    public LoginUserResponse findByUserNumberAndPassword(LoginUserRequest dto){
        if(String.valueOf(dto.getUserNumber()).length() < 8) {
            throw new UserNumberLimitException("학번은 8자리입니다.");
        }
        User loginUser = userDataRepository.findByUserNumberAndPassword(dto.getUserNumber(), dto.getPassword());

        try{
            String password = loginUser.getPassword();
        }catch (NullPointerException e){
            throw new UserNotFoundException("아이디 및 비밀번호를 확인해주세요");
        }

        return new LoginUserResponse(200, loginUser, "" ,"로그인을 성공하였습니다.");
    }


    public void testResponse(){
        throw new IllegalArgumentException("몰라용");
    }


}
