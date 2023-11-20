package com.kk.services.plots;


import com.kk.model.Plots;
import com.kk.repository.PlotRepository;
import com.kk.entities.LandLord;
import com.kk.entities.Plots;
import com.kk.models.request.CreatePlot;
import com.kk.models.request.UpdatePlotRequest;
import com.kk.models.response.PlotResponse;
import com.kk.repository.PlotRepository;
import com.kk.utils.IdGenerator;
import io.quarkus.redis.client.RedisClient;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.Locale;
import java.util.Optional;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class PlotsServiceImpl implements PlotsService{

    @Inject
    PlotRepository plotRepository;
    @Inject
    RedisClient redisClient;

    @Override
    @Transactional
    public Plots createPlot(Plots plot) {
        plotRepository.persist(plot);
        return plot;
    }

    @Override
    @Transactional
    public Plots updatePlot(Plots plot) {
        final Plots updatePlot = plotRepository.getEntityManager().merge(plot);
        plotRepository.persist(updatePlot);
        return updatePlot;
    }



    @Override
    @Transactional
    public PlotResponse createPlot(String landLordId, CreatePlot createPlot) {
        LandLord landLord = checkLnadlord(landLordId);
        Plots newPlot = new Plots();
        newPlot.setPlotId(IdGenerator.generatePlotId());
        newPlot.setPlotName(createPlot.getPlotName());
        newPlot.setNumberOfFloors(createPlot.getNumberOfFloors());
        newPlot.setNumberOfRooms(createPlot.getNumberOfRooms());
        newPlot.setDescription(createPlot.getDescription());
        newPlot.setLocation(createPlot.getLocation());
        newPlot.setLandLord(landLord);
        plotRepository.persist(newPlot);

        PlotResponse plotResponse = convertToPlotResponseModel(newPlot);
        return plotResponse;
    }

    public PlotResponse convertToPlotResponseModel(Plots plots){
        PlotResponse plotResponseResponse = new PlotResponse();
        plotResponseResponse.setPlotName(plots.getPlotName());
        plotResponseResponse.setNumberOfFloors(plots.getNumberOfFloors());
        plotResponseResponse.setNumberOfRooms(plots.getNumberOfRooms());
        plotResponseResponse.setDescription(plots.getDescription());
        plotResponseResponse.setLocation(plots.getLocation());
        plotResponseResponse.setLandLordId(plots.getLandLord().getId());
        return plotResponseResponse;
    }
    @Override
    @Transactional
    public PlotResponse updatePlot(String plotId, UpdatePlotRequest updatePlotRequest) {
        Plots plot = plotRepository.findById(Long.valueOf(plotId));
        if (updatePlotRequest != null){
            plot = new Plots();

            if (updatePlotRequest.getPlotName() != null){
                plot.setPlotName(updatePlotRequest.getPlotName());
            }

            if (updatePlotRequest.getNumberOfFloors() != null){
                plot.setNumberOfFloors(updatePlotRequest.getNumberOfFloors());
            }

            if(updatePlotRequest.getDescription() != null){
                plot.setDescription(updatePlotRequest.getDescription());
            }

            if (updatePlotRequest.getNumberOfRooms() != null){
                plot.setNumberOfRooms(updatePlotRequest.getNumberOfRooms());
            }

            if (updatePlotRequest.getLocation() != null){
                plot.setLocation(updatePlotRequest.getLocation());
            }

            plotRepository.persist(plot);
        }

        PlotResponse response = convertToPlotResponseModel(plot);

        return response;
    }

    @Transactional()
    public List<PlotResponse> getAllPlots() {
        List<Plots> plots = plotRepository.listAll();
        return plots.stream()
                .map(this::convertToPlotResponseModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Plots> findPlots() {
        return plotRepository.findAll().firstResultOptional();
    }

    @Override
    public Optional<Plots> deletePlots(int plotNo) {
        final Optional<Plots> plots = plotRepository.find("PlotNo", plotNo).firstResultOptional();
        if (plots.isPresent()) {
            plotRepository.update("Deleted WHERE PlotNo = ? ", plotNo);
    public Optional<Plots> deletePlots(Long plotId) {
        final Optional<Plots> plots = plotRepository.find("PlotNo", plotId).firstResultOptional();
        if (plots.isPresent()) {
            plotRepository.update("Deleted WHERE PlotNo = ? ", plotId);
        }
        return plots;
    }

    @Override
    public Optional<Plots> findVacantRooms(int plotNo) {
        return plotRepository.find("PlotNo = ?1 AND RoomStatus = ?2", plotNo, "Yes").firstResultOptional();
    public Optional<Plots> findVacantRooms(int plotId) {
        return plotRepository.find("PlotNo = ?1 AND RoomStatus = ?2", plotId, "Yes").firstResultOptional();
    }

    @Override
    public Optional<Plots> findPlotsByLocation(int plotNo, Locale location) {
        return plotRepository.find("PlotNo = ?1 AND location = ?2", plotNo, location).firstResultOptional();
    }
}
