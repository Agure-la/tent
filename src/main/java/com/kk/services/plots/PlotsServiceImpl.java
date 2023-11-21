package com.kk.services.plots;

import com.kk.exceptions.ResourceNotFoundException;
import com.kk.repository.PlotRepository;
import com.kk.entities.LandLord;
import com.kk.entities.Plots;
import com.kk.models.request.CreatePlot;
import com.kk.models.request.UpdatePlotRequest;
import com.kk.models.response.PlotResponse;
import com.kk.repository.PlotRepository;
import com.kk.services.landlord.LandlordServiceImpl;
import com.kk.utils.IdGenerator;
import io.quarkus.redis.client.RedisClient;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class PlotsServiceImpl implements PlotsService{

    @Inject
    PlotRepository plotRepository;
    @Inject
    RedisClient redisClient;

   @Inject
    LandlordServiceImpl landlordService;


    @Override
    @Transactional
    public PlotResponse createPlot(String landLordId, CreatePlot createPlot) {
        LandLord landLord = landlordService.checkLandlord(landLordId);
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

    public PlotResponse getPlot(String plotId){
        Plots plot = plotRepository.findById(Long.valueOf(plotId));
        if (plot != null) {
            return convertToPlotResponseModel(plot);
        } else {
            // You can throw an exception, return null, or handle it based on your requirements
            throw new ResourceNotFoundException("Plot not found with ID: " + plotId);
        }

    }

    @Transactional()
    public List<PlotResponse> getAllPlots() {
        List<Plots> plots = plotRepository.listAll();
        return plots.stream()
                .map(this::convertToPlotResponseModel)
                .collect(Collectors.toList());
    }


    public Optional<Plots> deletePlot(Long plotId) {
        final Optional<Plots> plots = plotRepository.findByIdOptional(plotId);
        if (plots.isPresent()) {
            plotRepository.deleteById(plotId);
        }
        return plots;
    }

}
