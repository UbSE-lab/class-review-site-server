package org.classreviewsite.auth.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InValidTokenException extends RuntimeException{
    public InValidTokenException(String message){
        super(message);
    }
}
