package org.classreviewsite.auth.exception;

public class UserNumberLimitException extends RuntimeException{
    public UserNumberLimitException(String message){
        super(message);
    }
}
