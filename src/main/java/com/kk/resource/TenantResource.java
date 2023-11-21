package com.kk.resource;

import com.kk.entities.Tenant;
import com.kk.exceptions.ResourceNotFoundException;
import com.kk.models.request.CreateTenantRequest;
import com.kk.models.response.TenantResponse;
import com.kk.services.tenant.TenantServiceImpl;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;


@Path("/api/tenants")
public class TenantResource {

    @Inject
    TenantServiceImpl tenantService;

    @POST
    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTenant(CreateTenantRequest createTenantRequest) {
        try {
            TenantResponse tenantResponse = tenantService.createTenant(createTenantRequest);
            return Response.status(Response.Status.CREATED).entity(tenantResponse).build();
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @RolesAllowed("Admin")
    @Path("/{id}")
    public Response deleteTenant(@PathParam("tenantId") Long tenantId) {
        try {
            Optional<Tenant> deletedTenant = tenantService.delete(String.valueOf(tenantId));
            if (deletedTenant.isPresent()) {
                return Response.status(Response.Status.NO_CONTENT).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Tenant not found with ID: " + tenantId).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTenants() {
        try {
            List<TenantResponse> tenants = tenantService.getAllTenant();
            return Response.status(Response.Status.OK).entity(tenants).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @RolesAllowed("Admin")
    @Path("/{plotName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTenantById(@PathParam("tenantId") Long tenantId) {
        try {
            Optional<TenantResponse> tenant = tenantService.find(String.valueOf(tenantId));
            return tenant.map(response -> Response.status(Response.Status.OK).entity(response).build())
                    .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).entity("Tenant not found with ID: " + tenantId).build());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @RolesAllowed("Admin")
    @Path("/plot/{plotId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTenantByPlot(@PathParam("plotId") Long plotId) {
        try {
            Optional<TenantResponse> tenant = tenantService.getTenantByPlots(String.valueOf(plotId));
            return tenant.map(response -> Response.status(Response.Status.OK).entity(response).build())
                    .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).entity("No tenant found in the specified plot").build());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
