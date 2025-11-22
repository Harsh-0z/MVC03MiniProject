package com.main.demo.mvc03miniproject.exception;

public class ActorNotFoundException extends RuntimeException{
    public ActorNotFoundException(){
        super();
    }
    public ActorNotFoundException(String message){
        super(message);
    }
}
