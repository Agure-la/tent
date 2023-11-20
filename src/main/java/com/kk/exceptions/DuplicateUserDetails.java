package com.kk.exceptions;

<<<<<<< HEAD
import com.kk.model.SystemUser;
=======
import com.kk.entities.SystemUser;
>>>>>>> a0d7678 (updated service class on function getAllPlots, updatePlot, createPlot)

public class DuplicateUserDetails extends TenantException {

    private final SystemUser user;

    public DuplicateUserDetails(SystemUser user) {
        this.user = user;
    }

    public SystemUser getUser(){
        return user;
    }
}
