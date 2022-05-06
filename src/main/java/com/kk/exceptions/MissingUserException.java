package com.kk.exceptions;

public class MissingUserException extends TenantException{

    private final String username;

    public MissingUserException(String username) {
        this.username = username;
    }

    public String getUsername(){
        return username;
    }
}
