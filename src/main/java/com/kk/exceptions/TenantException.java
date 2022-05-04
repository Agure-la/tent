package com.kk.exceptions;

public abstract class TenantException extends RuntimeException {

    public TenantException(){}

    public TenantException(String message){super(message);}

    public TenantException(String message, Throwable cause){super(message, cause);}

}
