package com.kk.resource;

import com.kk.entities.Plots;
import com.kk.exceptions.ResourceNotFoundException;
import com.kk.models.request.CreatePlot;
import com.kk.models.request.UpdatePlotRequest;
import com.kk.models.response.PlotResponse;
import com.kk.services.plots.PlotsServiceImpl;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/api/plots")
public class PlotsResource {

    @Inject
    PlotsServiceImpl plotsService;

    @POST
    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPlot(@QueryParam("landLordId") String landLordId, CreatePlot createPlot){
        try {
            PlotResponse plotResponse = plotsService.createPlot(landLordId, createPlot);
            return Response.status(Response.Status.CREATED).entity(plotResponse).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @RolesAllowed("Admin")
    @Path("/{plotId}")
    public Response updatePlot(@PathParam("plotId") String plotId, UpdatePlotRequest updatePlotRequest) {
        try {
            PlotResponse plotResponse = plotsService.updatePlot(plotId, updatePlotRequest);
            return Response.status(Response.Status.OK).entity(plotResponse).build();
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @RolesAllowed("Admin")
    @Path("/{plotId}")
    public Response getPlot(@PathParam("plotId") String plotId) {
        try {
            PlotResponse plotResponse = plotsService.getPlot(plotId);
            return Response.status(Response.Status.OK).entity(plotResponse).build();
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @RolesAllowed("Admin")
    public Response getAllPlots() {
        try {
            List<PlotResponse> plotResponses = plotsService.getAllPlots();
            return Response.status(Response.Status.OK).entity(plotResponses).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @RolesAllowed("Admin")
    @Path("/{plotId}")
    public Response deletePlot(@PathParam("plotId") Long plotId) {
        try {
            Optional<Plots> deletedPlot = plotsService.deletePlot(plotId);
            if (deletedPlot.isPresent()) {
                return Response.status(Response.Status.NO_CONTENT).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Plot not found with ID: " + plotId).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
