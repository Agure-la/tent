package com.kk.services.plots;

import com.kk.model.Plots;

import java.util.Locale;
import java.util.Optional;

public interface PlotsService {

    Plots createPlot(Plots plot);

    Plots updatePlot(Plots plot);

    Optional<Plots> findPlots();

    Optional<Plots> deletePlots(int plotNo);

    Optional<Plots> findVacantRooms(int plotNo);

    Optional<Plots> findPlotsByLocation(int plotNo, Locale locale);

}
