package com.lennys.exception;

public class VinAlreadyExistsException extends Exception{

    public VinAlreadyExistsException(String message){
        super(message);
    }

    public VinAlreadyExistsException(){
        super();
    }


}
