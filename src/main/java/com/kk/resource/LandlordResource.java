package com.kk.resource;

import com.kk.exceptions.ResourceNotFoundException;
import com.kk.models.request.CreateLandlordRequest;
import com.kk.models.request.UpdateLandlordRequest;
import com.kk.models.response.LandlordResponseModel;
import com.kk.services.landlord.LandlordService;
import io.micronaut.http.MediaType;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/landlord")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LandlordResource {

    @Inject
    private LandlordService landlordService;

    @POST
    @RolesAllowed("Admin")
    public Response createLandlord(CreateLandlordRequest createLandlordRequest) {
        try {
            LandlordResponseModel landlordResponseModel = landlordService.createLandlord(createLandlordRequest);
            return Response.status(Response.Status.CREATED).entity(landlordResponseModel).build();
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{landlordId}")
    public Response getLandlordById(@PathParam("landlordId") Long landlordId) {
        try {
            LandlordResponseModel landlordResponseModel = landlordService.getLandlordById(landlordId);
            return Response.status(Response.Status.OK).entity(landlordResponseModel).build();
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{landlordId}")
    @RolesAllowed("Admin")
    public Response updateLandlord(@PathParam("landlordId") String landlordId,
                                   UpdateLandlordRequest updateLandlordRequest) {
        try {
            LandlordResponseModel landlordResponseModel = landlordService.updateLandlord(landlordId, updateLandlordRequest);
            return Response.status(Response.Status.OK).entity(landlordResponseModel).build();
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{landlordId}")
    @RolesAllowed("Admin")
    public Response deleteLandlord(@PathParam("landlordId") Long landlordId) {
        try {
            landlordService.deleteLandlord(landlordId);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    public Response getAllLandlords() {
        try {
            List<LandlordResponseModel> landlords = landlordService.allLandlords();
            return Response.status(Response.Status.OK).entity(landlords).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
