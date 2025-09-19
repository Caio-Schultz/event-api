package dev.caioschultz.EventClean.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UniqueConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleUniqueConstraintViolationException(UniqueConstraintViolationException exception){
        Map<String, String> response = new HashMap<>();

        response.put("Error: ", exception.getMessage());
        response.put("Message: ", "Please, insert a valid hashId for you event!");

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(response);
    }

}
