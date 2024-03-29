package com.kk.exceptions;


import com.kk.entities.SystemUser;

public class DuplicateUserDetails extends TenantException {

    private final SystemUser user;

    public DuplicateUserDetails(SystemUser user) {
        this.user = user;
    }

    public SystemUser getUser(){
        return user;
    }
}
