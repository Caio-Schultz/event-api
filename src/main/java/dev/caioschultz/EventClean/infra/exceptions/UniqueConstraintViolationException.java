package dev.caioschultz.EventClean.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Unique Constraint Violation")
public class UniqueConstraintViolationException extends RuntimeException{

    public UniqueConstraintViolationException(String message){
        super(message);
    }

}
