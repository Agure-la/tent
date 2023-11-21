package com.kk.services.plots;

import com.kk.entities.Plots;
import com.kk.models.request.CreatePlot;
import com.kk.models.request.UpdatePlotRequest;
import com.kk.models.response.PlotResponse;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

public interface PlotsService {

    PlotResponse createPlot(String landLordId, CreatePlot createPlot);

    PlotResponse updatePlot(String plotId, UpdatePlotRequest updatePlotRequest);

    public List<PlotResponse> getAllPlots();

    public Optional<Plots> deletePlot(Long plotId);

}
