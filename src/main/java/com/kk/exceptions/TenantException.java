package com.kk.exceptions;

public abstract class TenantException extends RuntimeException {

    public TenantException(){}

    public TenantException(String message){super(message);}

    public TenantException(String message, Throwable cause){super(message, cause);}

    public TenantException(Throwable cause){super(cause);}

    public TenantException(String message, Throwable cause, boolean enableSuppression,
                           boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
