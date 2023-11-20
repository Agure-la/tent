package com.kk.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateLandlordRequest {

    @JsonProperty("landlordName")
    private String landlordName;

    @JsonProperty("phoneNo")
    private String phoneNo;

    @JsonProperty("email")
    private String email;

    @JsonProperty("plotName")
    private String plotName;

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
}
