package com.kk.resource;

import com.kk.model.Tenant;
import com.kk.services.tenant.TenantServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;


@Path("/api/tenants")
public class TenantResource {

    @Inject
    TenantServiceImpl tenantService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Tenant createTenant(Tenant tenant){
        return tenantService.createTenant(tenant);
    }

    @DELETE
    @Path("/{id}")
    public Optional<Tenant> deleteTenant(@PathParam("registrationNo") int registrationNo){
        return tenantService.delete(registrationNo);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Tenant getAllTenant(Tenant tenant){
        return tenantService.getAllTenant(tenant);
    }

    @GET
    @Path("/{plotName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Tenant> getTenantByPlots(String tenantName,@PathParam("plotName")  String plotName){
        return tenantService.getTenantByPlots(tenantName, plotName);
    }
}