package com.kk.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PlotListResponse {

@JsonProperty("plots")
    private List<PlotResponse> plots;

    public List<PlotResponse> getPlots() {
        return plots;
    }

    public void setPlots(List<PlotResponse> plots) {
        this.plots = plots;
    }
}
