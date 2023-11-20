package com.kk.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LandlordListResponse {

    @JsonProperty("landlords")
    private List<LandlordResponseModel> landlords;

    public List<LandlordResponseModel> getLandlords() {
        return landlords;
    }

    public void setLandlords(List<LandlordResponseModel> landlords) {
        this.landlords = landlords;
    }
}
