package dev.caioschultz.EventClean.infra.exceptions;

public class EventNotFoundException extends RuntimeException{

    public EventNotFoundException(String message){
        super(message);
    }

}
