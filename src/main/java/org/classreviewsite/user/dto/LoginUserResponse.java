package org.classreviewsite.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.classreviewsite.data.User;

@Data
@AllArgsConstructor
public class LoginUserResponse {

    private int status;

    private User user;

    private String token;

    private String message;

}
