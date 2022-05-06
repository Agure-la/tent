package com.kk.exceptions;

public class UnknownError extends TenantException{

    public UnknownError(){

    }

    public UnknownError(String message){super(message);}

    public UnknownError(String message, Throwable cause){super(message, cause);}

    public UnknownError(Throwable cause){super(cause);}
}
