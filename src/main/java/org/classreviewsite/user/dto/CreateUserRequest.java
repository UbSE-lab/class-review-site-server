package org.classreviewsite.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserRequest {

    private int userNumber;

    private String password;

    private String userName;

    private String department;

    private String nickname;


}
