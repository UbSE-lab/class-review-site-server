package org.classreviewsite.auth.handler;

import io.jsonwebtoken.MalformedJwtException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.apache.logging.log4j.message.ReusableMessage;
import org.classreviewsite.auth.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.ClassNotFoundException;
import java.util.HashMap;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    @Data
    @AllArgsConstructor
    class Result<T>{
        private int status;
        private T data;
        private String message;
    }


    @ExceptionHandler(value = NoSuchElementException.class)
    protected Result noSuchElementExceptionHandler(NoSuchElementException exception){
        return new Result(401, null, exception.getMessage());
    }

    @ExceptionHandler(value = InValidTokenException.class)
    protected Result inValidTokenException(InValidTokenException exception){
        return new Result(402, null, exception.getMessage());
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    protected Result UserNotFoundException(UserNotFoundException exception){
        return new Result(401, null, exception.getMessage());
    }

    @ExceptionHandler(value = UserExistException.class)
    protected Result UserExistException(UserExistException exception){
        return new Result(204, null, exception.getMessage());
    }

    @ExceptionHandler(value = UserNumberLimitException.class)
    protected Result UserNumberLimitException(UserNumberLimitException exception){
        return new Result(403, null, exception.getMessage());
    }

    @ExceptionHandler(value = LectureNotFoundException.class)
    protected Result LectureNotFoundException(LectureNotFoundException exception){
        return new Result(401, null, exception.getMessage());
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    protected Result IllegalArgumentException(IllegalArgumentException exception){
        return new Result(403, null, exception.getMessage());
    }

    @ExceptionHandler(value = ReviewNotFoundException.class)
    protected Result ReviewNotFoundException(ReviewNotFoundException exception){
        return new Result(202, null, exception.getMessage());
    }

    @ExceptionHandler(value = MalformedJwtException.class)
    protected Result MalformedJwtException(MalformedJwtException exception){
        return new Result(401, null, "토큰이 유효하지 않습니다.");
    }

    @ExceptionHandler(value = AlreadyWritePostException.class)
    protected Result AlreadyWritePostException(AlreadyWritePostException exception){
        return new Result(401, null, exception.getMessage());
    }

    @ExceptionHandler(value = AlreadyLikeException.class)
    protected Result AlreadyLikeException(AlreadyLikeException exception){
        return new Result(202, null, exception.getMessage());
    }

    @ExceptionHandler(value = ClassNotFoundException.class)
    protected Result ClassNotFoundException(ClassNotFoundException exception){
        return new Result(202, null, exception.getMessage());
    }


}
