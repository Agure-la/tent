package com.kk.resource;

<<<<<<< HEAD
import com.kk.model.Plots;
=======
import com.kk.entities.Plots;
>>>>>>> a0d7678 (updated service class on function getAllPlots, updatePlot, createPlot)
import com.kk.services.plots.PlotsServiceImpl;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Locale;
import java.util.Optional;

@Path("/api/plots")
public class PlotsResource {

    @Inject
    PlotsServiceImpl plotsService;

    @POST
    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Plots addPlot(Plots plot){
        return plotsService.createPlot(plot);
    }

    @PUT
    @RolesAllowed("Admin")
    @Consumes(MediaType.APPLICATION_JSON)
    public Plots editPlot(Plots plot){
        return plotsService.updatePlot(plot);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Plots> searchPlots(){
        return plotsService.findPlots();
    }

    @GET
    @Path("/{location}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Plots> searchPlotsByLocation(int plotNo,@PathParam("location") Locale location){
        return plotsService.findPlotsByLocation(plotNo, location);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Plots> searchVacantRooms(@PathParam("int plotNo") int plotNo){
        return plotsService.findVacantRooms(plotNo);
    }
}
