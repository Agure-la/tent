package com.kk.exceptions;

public class MissingRefreshTokenException extends TenantException{
    private final String token;

    public MissingRefreshTokenException(String token) {
        this.token = token;
    }
    public String getToken (){
        return token;
    }
}
