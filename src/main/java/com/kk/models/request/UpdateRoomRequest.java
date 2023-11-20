package com.kk.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateRoomRequest {

    @JsonProperty("roomNumber")
    private String roomNumber;

    @JsonProperty("isBooked")
    private boolean isBooked;

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
