package org.classreviewsite.auth.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.classreviewsite.auth.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    @ExceptionHandler(value = NoSuchElementException.class)
    protected ResponseEntity<HashMap<String, Object>> noSuchElementExceptionHandler(NoSuchElementException exception){
        HashMap<String, Object> response = new HashMap<>();

        response.put("status", 401);
        response.put("message", exception.getMessage());
        return new ResponseEntity<>(response, NOT_FOUND);
    }

    @ExceptionHandler(value = InValidTokenException.class)
    protected ResponseEntity<HashMap<String, Object>> inValidTokenException(InValidTokenException exception){
        HashMap<String, Object> response = new HashMap<>();

        response.put("status" , 402);
        response.put("message", exception.getMessage());
        return new ResponseEntity<>(response, NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    protected ResponseEntity<HashMap<String, Object>> UserNotFoundException(UserNotFoundException exception){
        HashMap<String, Object> response = new HashMap<>();

        response.put("status", 401);
        response.put("message", exception.getMessage());
        return new ResponseEntity<>(response, NOT_FOUND);
    }

    @ExceptionHandler(value = UserExistException.class)
    protected ResponseEntity<HashMap<String, Object>> UserExistException(UserExistException exception){
        log.info("??" );
        HashMap<String, Object> response = new HashMap<>();

        response.put("status", 204);
        response.put("message", exception.getMessage());
        return new ResponseEntity<>(response, NO_CONTENT);
    }

    @ExceptionHandler(value = UserNumberLimitException.class)
    protected ResponseEntity<HashMap<String, Object>> UserNumberLimitException(UserNumberLimitException exception){
        HashMap<String, Object> response = new HashMap<>();

        response.put("status", 403);
        response.put("message", exception.getMessage());
        return new ResponseEntity<>(response, FORBIDDEN);
    }

    @ExceptionHandler(value = LectureNotFoundException.class)
    protected ResponseEntity<HashMap<String,Object>> LectureNotFoundException(LectureNotFoundException exception){
        HashMap<String, Object> response = new HashMap<>();

        response.put("status", 401);
        response.put("message", exception.getMessage());
        return new ResponseEntity<>(response, NOT_FOUND);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    protected ResponseEntity<HashMap<String, Object>> IllegalArgumentException(IllegalArgumentException exception){
        HashMap<String, Object> response = new HashMap<>();

        response.put("status", 403);
        response.put("message", exception.getMessage());
        return new ResponseEntity<>(response, NOT_FOUND);
    }


}
