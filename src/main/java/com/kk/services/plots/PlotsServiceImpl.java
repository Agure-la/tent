package com.kk.services.plots;

import com.kk.model.Plots;
import com.kk.repository.PlotRepository;
import io.quarkus.redis.client.RedisClient;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.Locale;
import java.util.Optional;

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
    public Optional<Plots> findPlots() {
        return plotRepository.findAll().firstResultOptional();
    }

    @Override
    public Optional<Plots> deletePlots(int plotNo) {
        final Optional<Plots> plots = plotRepository.find("PlotNo", plotNo).firstResultOptional();
        if (plots.isPresent()) {
            plotRepository.update("Deleted WHERE PlotNo = ? ", plotNo);
        }
        return plots;
    }

    @Override
    public Optional<Plots> findVacantRooms(int plotNo) {
        return plotRepository.find("PlotNo = ?1 AND RoomStatus = ?2", plotNo, "Yes").firstResultOptional();
    }

    @Override
    public Optional<Plots> findPlotsByLocation(int plotNo, Locale location) {
        return plotRepository.find("PlotNo = ?1 AND location = ?2", plotNo, location).firstResultOptional();
    }
}
