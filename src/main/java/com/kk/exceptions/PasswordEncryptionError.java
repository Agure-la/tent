package com.kk.exceptions;

public class PasswordEncryptionError extends TenantException{
    public PasswordEncryptionError(Exception e){
        super(e);
    }
}
