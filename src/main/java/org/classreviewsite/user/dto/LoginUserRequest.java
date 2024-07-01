package org.classreviewsite.user.dto;

import lombok.Data;

@Data
public class LoginUserRequest {

    private int userNumber;

    private String password;

}
