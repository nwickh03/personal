package com.lennys.exception;

public class DBException extends Exception {

    public DBException() {}

    public DBException(String message){
        super(message);
    }
}
