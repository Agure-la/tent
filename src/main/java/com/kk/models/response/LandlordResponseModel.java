package com.kk.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LandlordResponseModel {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("landlordId")
    private String landlordId;

    @JsonProperty("landlordName")
    private String landlordName;

    @JsonProperty("phoneNo")
    private String phoneNo;

    @JsonProperty("email")
    private String email;

    @JsonProperty("plotName")
    private String plotName;

    @JsonProperty("plots")
    private List<PlotResponse> plots;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(String landlordId) {
        this.landlordId = landlordId;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public List<PlotResponse> getPlots() {
        return plots;
    }

    public void setPlots(List<PlotResponse> plots) {
        this.plots = plots;
    }
}
