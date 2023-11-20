package com.kk.resource;

<<<<<<< HEAD
import com.kk.model.SystemUser;
=======
import com.kk.entities.SystemUser;
>>>>>>> a0d7678 (updated service class on function getAllPlots, updatePlot, createPlot)
import com.kk.resource.requests.CreateUserRequestModel;
import com.kk.services.user.UserServiceImpl;


import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import javax.ws.rs.core.Response;

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserServiceImpl userServiceImpl;

    @POST
    public Response registerUser(CreateUserRequestModel createUserRequestModel) throws Exception {

        final SystemUser user = userServiceImpl.createUser(createUserRequestModel);

        return Response.ok(user).build();
    }

    @GET
    @RolesAllowed("Admin")
    @Path("usernameOrEmail")
    public Optional<SystemUser> getUser(@PathParam("usernameOrEmail") String usernameOrEmail, String password){
        return userServiceImpl.findUser(usernameOrEmail, password);

    }

    @GET
    @RolesAllowed("Admin")
    @Path("username")
    public Optional<SystemUser> getUser(@PathParam("username") String username){
        return userServiceImpl.findUser(username);
    }

    @GET
    @RolesAllowed("Admin")
    @Path("/{id}")
    public Optional<SystemUser> getUser(@PathParam("userId" ) Long userId){
        return userServiceImpl.findUser(userId);
    }

    @PUT
    public SystemUser updateUser(SystemUser systemUser){
        return userServiceImpl.updateUserPassword(systemUser);
    }

    @DELETE
    @RolesAllowed("Admin")
    @Path("/{id}")
    public Optional<SystemUser> deleteUser(@PathParam("userId") long userId){
        return userServiceImpl.delete(userId);
    }

//    @PUT
//    @Path("/{id}")
//    public Response resetPassword(@PathParam("userId") Long userId,  String currentPassword, String newPassword){
//        userServiceImpl.updateUserPassword(userId, currentPassword, newPassword);
//
//        return Response.ok().build();
//    }

}
