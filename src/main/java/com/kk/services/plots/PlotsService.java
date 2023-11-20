package com.kk.services.plots;

import com.kk.model.Plots;
import com.kk.entities.LandLord;
import com.kk.entities.Plots;
import com.kk.models.request.CreatePlot;
import com.kk.models.request.UpdatePlotRequest;
import com.kk.models.response.PlotResponse;

import java.util.Locale;
import java.util.Optional;

public interface PlotsService {
    Plots createPlot(Plots plot);

    Plots updatePlot(Plots plot);

    Optional<Plots> findPlots();

    Optional<Plots> deletePlots(int plotNo);

    Optional<Plots> findVacantRooms(int plotNo);
    PlotResponse createPlot(String landLordId, CreatePlot createPlot);

    PlotResponse updatePlot(String plotId, UpdatePlotRequest updatePlotRequest);

    Optional<Plots> findPlots();

    Optional<Plots> deletePlots(Long plotId);

    Optional<Plots> findVacantRooms(Long plotId);

    Optional<Plots> findPlotsByLocation(int plotNo, Locale locale);

}
