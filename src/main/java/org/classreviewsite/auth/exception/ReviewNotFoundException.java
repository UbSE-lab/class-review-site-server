package org.classreviewsite.auth.exception;

public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException(String message){
        super(message);
    }
}
