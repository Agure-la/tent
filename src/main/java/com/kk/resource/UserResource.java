package com.kk.resource;

import com.kk.model.SystemUser;
import com.kk.services.user.UserSvc;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/api/users")
public class UserResource {

    @Inject
    UserSvc userSvc;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public SystemUser registerUser(String username, String email, String password, String phoneNo,
                                 String fullName) throws Exception {
        return userSvc.createUser(username, email, password, phoneNo, fullName);
    }

    @GET
    @Path("usernameOrEmail")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<SystemUser> getUser(@PathParam("usernameOrEmail") String usernameOrEmail, String password){
        return userSvc.findUser(usernameOrEmail, password);

    }

    @GET
    @Path("username")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<SystemUser> getUser(@PathParam("username") String username){
        return userSvc.findUser(username);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<SystemUser> getUser(@PathParam("userId" ) Long userId){
        return userSvc.findUser(userId);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public SystemUser updateUser(SystemUser systemUser){
        return userSvc.updateUserPassword(systemUser);
    }

    @DELETE
    @Path("/{id}")
    public Optional<SystemUser> deleteUser(@PathParam("userId") long userId){
        return userSvc.delete(userId);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void resetPassword(@PathParam("userId") Long userId, String currentPassword, String newPassword){
        userSvc.updateUserPassword(userId, currentPassword, newPassword);
    }

}
