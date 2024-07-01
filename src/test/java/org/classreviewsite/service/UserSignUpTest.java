//package org.classreviewsite.service;
//
//import org.classreviewsite.user.service.UserService;
//import org.classreviewsite.user.dto.CreateUserRequest;
//import org.classreviewsite.user.dto.CreateUserResponse;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//
//@RunWith(Parameterized.class)
//public class UserSignUpTest {
//
//    UserService userService;
//
//    private int userNumber;
//
//    private String password;
//
//    @Parameterized.Parameters
//    public static Collection<int[]> getUserNumberParameters(){
//        return Arrays.asList(new int[][]{
//            {20191434},
//            {20191585},
//            {20191476},
//            {2019123},
//        });
//    }
//
////    @Parameterized.Parameters
////    public static Collection<String[]> getUserPasswordParameters(){
////        return Arrays.asList(new String[][]{
////                {"alsdl1004"},
////                {"1234"},
////                {"1234"},
////                {"1234"}
////        });
////    }
//
//    public UserSignUpTest(int userNumber ){
//        this.userNumber = userNumber;
//    }
//
//    @Test
//    @Transactional
//    public void SignUpTest(){
//
//        CreateUserRequest request = CreateUserRequest.builder()
//                .userNumber(userNumber)
//                .build();
//
//
//        CreateUserResponse response = userService.signUp(request);
//
//        Assertions.assertNotNull(response);
//
//
//    }
//
//
//
//}
