package org.classreviewsite.auth.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AlreadyWritePostException extends RuntimeException{
    public AlreadyWritePostException(String message){
        super(message);
    }

}
