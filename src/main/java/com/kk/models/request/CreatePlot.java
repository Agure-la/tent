package com.kk.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatePlot {

    @JsonProperty("plotId")
    private String plotId;

    @JsonProperty("plotName")
    private String plotName;

    @JsonProperty("numberOfFloors")
    private Integer numberOfFloors;

    @JsonProperty("description")
    private String description;

    @JsonProperty("numberOfRooms")
    private String numberOfRooms;

    @JsonProperty("ocation")
    private String location;

    @JsonProperty("landLordId")
    private Long landLordId;  // provide the landLordId when creating a plot

    public String getPlotId() {
        return plotId;
    }

    public void setPlotId(String plotId) {
        this.plotId = plotId;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getLandLordId() {
        return landLordId;
    }

    public void setLandLordId(Long landLordId) {
        this.landLordId = landLordId;
    }
}
